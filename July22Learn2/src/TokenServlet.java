import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TokenServlet extends HttpServlet {
    private Map<String,List<String>>cityMap=new HashMap<>();
    private Map<String,List<String>>countryMap=new HashMap<>();

    @Override
    public void init()
    {List<String>ShanXi=new ArrayList<>();
        ShanXi.add("XiAn");
        ShanXi.add("BaoJi");
        ShanXi.add("TongChuan");
        ShanXi.add("XianYang");
        cityMap.put("ShanXi",ShanXi);
        List<String>Xian=new ArrayList<>();
        Xian.add("LinTong");
        Xian.add("BaQiao");
        Xian.add("ChangAn");
        countryMap.put("XiAn",Xian);}

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException
    {resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer=resp.getWriter();
        String pro=req.getParameter("pro");
        String city=req.getParameter("city");

        if(pro==null&&city==null)
        {
            resp.setContentType("text/html'");
            writer.println("<html>");
            writer.println("<head>");
            writer.println("<title>Pro-city-reg</title>");
            writer.println("</head>");
            writer.println("<body>");
            writer.println("Please select a province:<br />");
            writer.println("<a href='?pro=ShanXi'>陕西省</a><br />");
            writer.println("</body>");
            writer.println("</html>"); }
        else
        {if(pro==null)
        {writer.write("pro省份参数不能为空");}
        else
        {if(city==null)    //省份不为空
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
                    .append("陕西省")
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
                if(countryMap.get(city)==null)
                    writer.write("暂无");

                else{        for(String country:countryMap.get(city))
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
                    writer.write(sb.toString());}}
            else
            {writer.write(city+"不属于"+pro);}}
        }
        }
    }
}