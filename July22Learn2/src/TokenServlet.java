import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TokenServlet extends HttpServlet {
private Map<String,List<String>>cityMap=new HashMap<>();
private Map<String,List<String>>countryMap=new HashMap<>();



    @Override
    protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer=resp.getWriter();
        writer.append("<html>")
                .append("<head>")
                .append("<meta charset='UTF-8'>")
                .append("<title>CityQuery</title>")
                .append("</head>")
                .append("<body>")
                .append("<form method='POST'action='/token'>")
                .append("请输入省份")
                .append("<input name='pro' type='text' />")
                .append("请输入城市")
                .append("<input name='city' type='text' />")
                .append("<input type='submit' value='查询'/>")
                .append("</form>")
                .append("</body>")
                .append("</html>");




    }






@Override
public void init()
{List<String>ShanXi=new ArrayList<>();
    ShanXi.add("西安市");
    ShanXi.add("宝鸡市");
    ShanXi.add("铜川市");
    ShanXi.add("咸阳市");
   cityMap.put("陕西省",ShanXi);


   List<String>Xisn=new ArrayList<>();

   Xisn.add("临潼区");
    Xisn.add("灞桥区");
    Xisn.add("长安区");
    countryMap.put("西安市",Xisn);}









   @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException
   {resp.setContentType("text/html;charset=UTF-8");
       PrintWriter writer=resp.getWriter();
       String pro=req.getParameter("pro");
       String city=req.getParameter("city");
       if(pro==null&&city==null)
       {writer.write("没有数据");}
       else
           {if(pro==null)
           {writer.write("pro省份参数不能为空");}
           else
           {if(city==null)
           {List<String> cityList=cityMap.get(pro);
           StringBuilder sb=new StringBuilder();
           for(String c:cityList)
           {sb.append("<a href='/token")
                   .append("?")
                   .append("pro=")
                   .append(pro)
                   .append("&")
                   .append("city=")
                   .append(c)
                   .append("'>")
                   .append(pro)
                   .append(",")
                   .append(c)
                   .append("</a>")
                   .append("</br>");
           }

           writer.write(sb.toString());}

           else

           {List<String> cityList=cityMap.get(pro);
           if(cityList.contains(city))
           {StringBuilder sb=new StringBuilder();
           for(String country:cityMap.get(city))
           {sb.append("<a href='/token")
           .append("?")
                   .append("pro=").append(pro)
                   .append("&")
                   .append("city=")
                   .append(city)
                   .append(" '>")
                   .append(pro)
                   .append(",")
                   .append(city)
                   .append(",")
                   .append(country)
                   .append("</a>")
                   .append("</br>"); }

                   writer.write(sb.toString());}
                   else
           {writer.write(city+"不属于"+pro);}
           }

           }


           }



           }




           }
