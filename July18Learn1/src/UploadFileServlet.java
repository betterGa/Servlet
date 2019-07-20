import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;

public class UploadFileServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse reps) throws IOException, ServletException {
Part part=req.getPart("filename");
        InputStream is=part.getInputStream();
        String appuploadPath=req.getServletContext().getRealPath("/upload");
        File file=new File(appuploadPath,part.getSubmittedFileName());
if(!file.getParentFile().exists())
{file.getParentFile().mkdirs();}

        OutputStream out=new FileOutputStream(file);
        byte[] buff=new byte[1024];
        int len=-1;
        while((len=is.read(buff))!=-1)
            {out.write(buff,0,len);}
    out.close();
    is.close();
    reps.setContentType("text/html;charset=UTF-8");
    PrintWriter writer=reps.getWriter();
        String cd = part.getHeader("Content-Disposition");
        String filename = cd.substring(cd.lastIndexOf("=")+2, cd.length()-1);
    writer.append("<html>")
            .append("<head>")
            .append("<meta charset='UTF-8'>")
            .append("<title>File</title>")
            .append("</head>")
            .append("<body>")
            .append("<a href='")
           // .append("/upload/").append(part.getSuhmittedFileName())
            //在tomcat7 的环境下就没有part.getSubmittedFileName()这一方法，无法直接获取文件名。
            .append("/upload/").append(filename)
            .append("")
            .append("")
            .append("'>")

            .append("上传的文件")
            .append("</a>")
            .append("</body>")
            .append("</html>");








    }

    }





