import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Top10Servlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private List<String> londonAttractions;
    private List<String> parisAttractions;

    public Top10Servlet() {
        super();
    }
    @Override
    public void init() throws ServletException {  // 用户第一次访问时，Tomcat初始化Servlet，init()方法被调用。
        londonAttractions = new ArrayList<String>(10);  // 赋值类的成员变量
        londonAttractions.add("1.Buckingham Palace");
        londonAttractions.add("2.Lodon Eye");
        londonAttractions.add("3.British Museum");
        londonAttractions.add("4.National Gallery");
        londonAttractions.add("5.Big Ben");
        londonAttractions.add("6.Tower of London");
        londonAttractions.add("7.Natural History Museum");
        londonAttractions.add("8.Canary Wharf");
        londonAttractions.add("9.2012 Olympic Park");
        londonAttractions.add("10.ST Paul's Cathedral");

        parisAttractions = new ArrayList<String>(10);  // 赋值类的成员变量
        parisAttractions.add("1.Eiffel Tower");
        parisAttractions.add("2.Notre Dame");
        parisAttractions.add("3.The Louver");
        parisAttractions.add("4.Champs Elysees");
        parisAttractions.add("5.Arc de Triomphe");
        parisAttractions.add("6.Sainte Chapelle Church");
        parisAttractions.add("7.Les Invalides");
        parisAttractions.add("8.Muess d'Orsay");
        parisAttractions.add("9.Montmarte");
        parisAttractions.add("10.Sacre Couer Basilica");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String city = request.getParameter("city");  // 获取token的值，该token随URL传递过来
        if (city != null && (city.equals("london") || city.equals("paris"))) {
            showAttractions(request, response, city);
        } else { showMainPage(request, response);
        }
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }
    private void showMainPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();  // 向客户端发送信息
        writer.println("<html>");
        writer.println("<head>");
        writer.println("<title>Top10 Tourist Atrractions</title>");
        writer.println("</head>");
        writer.println("<body>");
        writer.println("Please select a city:<br />");
        writer.println("<a href='?city=london'>London</a><br />");  // 相对url,由 http://localhost:8080/top10/top10
        writer.println("<a href='?city=paris'>Paris</a><br />");    //      变为  http://localhost:8080/top10/top10?city=london
        writer.println("</body>");                                  // 并将后者发送到服务器
        writer.println("</html>");
    }
    private void showAttractions(HttpServletRequest request, HttpServletResponse response, String city) throws ServletException, IOException {
        int page = 1;
        String pageParameter = request.getParameter("page");  // 获取token的值
        if (pageParameter != null) {
            try {
                page = Integer.parseInt(pageParameter);
            }catch(NumberFormatException e) {
                e.printStackTrace();
            }
            if (page > 2) {
                page = 1;
            }
        }
        List<String> attractions = null;
        if (city.equals("london")) {
            attractions = londonAttractions;
        } else {
            attractions = parisAttractions;
        }
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<head>");
        writer.println("<title>Top 10 Tourist Attractions</title>");
        writer.println("</head>");
        writer.println("<body>");
        writer.println("<a href='top10'>Select City</a>");  // 相对url 由 http://localhost:8080/top10/top10?city=london
        writer.println("<hr />");                           //      变为  http://localhost:8080/top10/top10
        writer.println("Page " + page);
        writer.println("<hr />");
        int start = page * 5 -5;
        for (int i = start; i < start + 5; i++) {
            writer.println(attractions.get(i) + "<br />");
        }
        writer.print("<hr style='color:blue' />");
        writer.println("<a href='?city=" + city + "&page=1'>Page 1</a>");  // 由 localhost:8080/top10/top10?city=london 变为 localhost:8080/top10/top10?city=london&page=1
        writer.println("&nbsp;<a href='?city=" + city + "&page=2'>Page 2</a>");  // 由 localhost:8080/top10/top10?city=london 变为 localhost:8080/top10/top10?city=london&page=2
        writer.println("</body>");
        writer.println("</html>");
    }
}