import org.omg.CORBA.Request;
import sun.net.httpserver.HttpServerImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "SumServlet", urlPatterns = "/sum")
public class Sum extends HttpServlet{

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{

        int a = 0, b = 0;
        a  =Integer.parseInt(request.getParameter("num1"));
        b = Integer.parseInt(request.getParameter("num2"));
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h3> Sum res: " +(a+b)+ "</h3" );
    }
}
