import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "array", urlPatterns = "/array")

public class ArrayServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        int size = Integer.parseInt(request.getParameter("size"));
        String value = request.getParameter("value");

        String[] array = new String[size];

        for(int  i = 0; size < array.length; i ++){
           array[i] = value;
        }

        out.println("<table border=1>");
        out.println("<tr>");

        for(String string : array) {
            out.println("<td>" + string + "/<td>");
        }

        out.println("</tr>");
        out.println("</table>");

    }
}
