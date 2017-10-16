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
        ArrayList input [] = new ArrayList[10];

        int size = String.valueOf(input).length();
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("a href=\"" + "?" +size +"size=3" +  input +"fill=fer");

    }
}
