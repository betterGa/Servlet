import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
        baoji.add("太白山");
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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        String city = req.getParameter("city");
        List<ScenicSpot> scenicSpotstoArrayList = new ArrayList<ScenicSpot>();
        if(city==null||city.length()==0)
        {for(Map.Entry<String,List<String>> entry:scenicSpot.entrySet()  )
        {
String citykey=entry.getKey();
List<String> scenics=entry.getValue();

for(String item:scenics)
{ScenicSpot scenicSpot=new ScenicSpot();
scenicSpot.setCity(cityMap.get(citykey));
scenicSpot.setName(item);
scenicSpotstoArrayList.add(scenicSpot);
}
        }




        }

    }
    public static class ScenicSpot
    {private String city;
    private String name;

        public static String setCity(String city) {
            return city;
        }

        public static String setName(String name) {
            return name;
        }
    }
}