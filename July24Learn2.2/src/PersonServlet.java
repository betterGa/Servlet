import com.sun.deploy.net.HttpResponse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class PersonServlet extends HiddenServlet{

    @Override
    public  void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {res.setContentType("text/html;charset=UTF-8");
res.setContentType("text/html;charset=UTF-8");
        PrintWriter writer=res.getWriter();
        String id=req.getParameter("id");
if(id==null)
{writer.append("参数不能为空");}
else
    {Person person=personMap.get(id);
    writer.append("<!DOCTYPE html>\n"+
    "<html lang=\"en\">\n"
    +"<head>\n"
    +"<meta charset=\"UTF-8\">\n"
            +"<title>修改人员信息</title>\n"
            +"</head>\n"
            +"<body>\n"
            +"<h1>修改人员信息</h1>\n"
            +"<form method=\"post\" action=\"/person\">\n"
+"<input type=\"text\" name=\"id\" hidden=\"hidden\" value=\""+person.getId()+"\"/>\n"
+"姓名:<input type=\"text\" name=\"name\" value=\""+person.getName()+"\" placeholder=\"请输入姓名\">\n"
+"年龄:<input type=\"text\" name=\"age\"   value=\"" +person.getAge()+"\" placeholder=\"请输入年龄\">\n"
+"<input type=\"submit\" value=\"保存更新\">\n"
            +"</form>\n"
            +"</body>\n"
            +"</html>\n");

    }}


    @Override
    protected void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException {res.setContentType("text/html;charset=UTF-8");
    PrintWriter writer=res.getWriter();
    String id=req.getParameter("id");
    if(id==null)
    {writer.append("暂时不支持"); }
        else
    {String name=req.getParameter("name");
    String agestr=req.getParameter("age");
    Person person=personMap.get(id);
    person.setAge(Integer.parseInt(agestr));
    person.setName(name);
    writer.append("<a href='/hidden'>")
.append("回到列表")
.append("</a>");
    }

    }




    }






