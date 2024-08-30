import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);

        resp.setDateHeader("Expires",0);
        resp.setHeader("Cache-Control","no-cache");
        resp.getWriter().write("这是我的第一个servlet");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().flush();
    }
}
