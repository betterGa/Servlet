package com.MyServer;

import javax.servlet.*;
import javax.servlet.ServletConfig;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

public class Loginc extends FirstServlet{

    @Override
    public void service(ServletRequest arg0,ServletResponse arg1) throws IOException
    {String user=arg0.getParameter("username");

    /*public String getParameter(String name)
        以 String 形式返回请求参数的值，如果该参数不存在，则返回 null。请求参数是与请求一起发送的额外信息。对于 HTTP servlet，参数包含在查询字符串或发送的表单数据中。
        只有在确定参数只有一个值时，才应该使用此方法。如果参数可能拥有一个以上的值，则使用 #getParameterValues。*/

    String pass=arg0.getParameter("password");


    arg1.setCharacterEncoding("GB2312");


        if(user.equals("2086543608@qq.com")&&pass.equals("jdpy"))
        {arg1.getWriter().println("欢迎登录");}

        /* public java.io.PrintWriter getWriter() throws java.io.IOException
返回可将字符文本发送到客户端的 PrintWriter 对象。
PrintWriter 使用 #getCharacterEncoding 返回的字符编码。
如果未如 getCharacterEncoding 中所述指定响应的字符编码（即该方法只返回默认值 ISO-8859-1），
则 getWriter 会将字符编码更新到 ISO-8859-1。 */

        else
        {arg1.getWriter().println("验证失败");} }


    }

