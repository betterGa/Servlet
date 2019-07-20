import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QueryServlet extends HttpServlet {

    private Map<String, String> cityMap = new HashMap<String, String>();
    private Map<String, List<String>> scenicSpot = new HashMap<String, List<String>>();

    @Override
    public void init() throws ServletException {
        super.init();
        List<String> xian = new ArrayList<>();
        xian.add("华清池");
        xian.add("兵马俑");
        xian.add("大雁塔");
        scenicSpot.put("Xi'an", xian);
        cityMap.put("Xi'an", "西安");

        List<String> baoji = new ArrayList<String>();
        //baoji.add("太白山");
        baoji.add("法门寺");
        baoji.add("关山牧场");
        scenicSpot.put("BaoJi", baoji);
        cityMap.put("BaoJi", "宝鸡");

        List<String> xianyang = new ArrayList<String>();
        xianyang.add("乾陵");
        xianyang.add("袁家村");
        scenicSpot.put("XianYang", xianyang);
        cityMap.put("XianYang", "咸阳");
    }




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
                .append("<form method='POST'action='/query'>")
                .append("请输入城市")
                .append("<input name='city' type='text' />")
                .append("<input type='submit' value='查询'/>")
                .append("</form>")
                .append("</body>")
                .append("</html>");




    }














    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String city = req.getParameter("city");
        List<ScenicSpot> scenicSpotstoArrayList = new ArrayList<ScenicSpot>();
        if(city==null||city.length()==0)

        {for(Map.Entry<String,List<String>> entry:scenicSpot.entrySet())
        { String citykey=entry.getKey();
            List<String> scenics=entry.getValue();

            for(String item:scenics)
{ ScenicSpot scenicSpotcla=new ScenicSpot();
    scenicSpotcla.setCity(cityMap.get(citykey));
scenicSpotcla.setName(item);
    scenicSpotstoArrayList.add(scenicSpotcla);
}
        } }
else
    {List<String>scenics=scenicSpot.get(city);
    if(scenics==null)
    {scenics=new ArrayList<String>();}

    for(String item:scenics)
    {ScenicSpot scenicSpotcla=new ScenicSpot();
    scenicSpotcla.setCity(cityMap.get(city));
    scenicSpotcla.setName(item);
    scenicSpotstoArrayList.add(scenicSpotcla);}
    }
    resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer=resp.getWriter();
        writer.append("<!DOCTYPE html>\n"+
                "<html lang=\"en\">+\n"+
                "<head>\n"+
                "<meta charset=\"UTF-8\">\n"+
                "<title>景点</title>\n"+
                "</head>\n"+
                "<body>\n"+
                "<table>\n"+
                "<thead>\n"+
                "<tr>\n"+
                "<td>编号</td>\n"+
                "<td>所在城市</td>\n"+
                "<td>景点名称</td>\n"+
                "</tr>\n"+
                "</thead>\n"+
                "<tbody>");

int id=1;
for(ScenicSpot pot:scenicSpotstoArrayList)
{writer.append("<tr>")
        .append("<td>") .append(String.valueOf(id)) .append("</td>")
        .append("<td>") .append(pot.city) .append("</td>")
        .append("<td>") .append(pot.name) .append("</td>")
        .append("</tr>");
    id=id+1; }

writer.append("</tbody>\n"+
        "</table>\n"+
"</body>\n"+
"</html>"); }




    public  class ScenicSpot
    {private String city;
    private String name;

        public void setCity(String city) {
            this.city = city;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}