import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/*将HTML从一个Servlet发送到浏览器。表单视图*/

public class FormServlet extends HttpServlet {
    @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer=resp.getWriter();
        writer.append("<html>")
                .append("<head>")
                .append("<meta charset='UTF-8'>")
                .append("<title>Form</title>")
                .append("<head>")
                .append("<body>")
                .append("<form method='POST' action=' '>")
                .append("请输入姓名:")
                .append("<input name='name' type='text' value=''/>")
                .append("<input type='submit' value-'提交'>")
                .append("</form>")
                .append("</body>")
                .append("</html>");
        }






        @Override
    protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws IOException {String name=req.getParameter("name");
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer=resp.getWriter();
        writer.append("<html>")
                .append("<head>")
                .append("<meta charset='UTF-8'>")
                .append("<title>Form</title>")
                .append("</head>")
                .append("<body>")
                .append("<h1>")
                .append("欢迎")
                .append(name)
                .append("</h1>")
                .append("</body>")
                .append("</html>"); }
                }
