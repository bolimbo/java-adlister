import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "counter", urlPatterns = "/count")

public class ViewCounter extends HttpServlet {
    int counter = 0;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();


        if(request.getParameter("reset")!=null) {
            counter = 0;
          out.println(counter);
        } else {
            counter++;
            out.println( + counter );
            out.println("<a href=\"" +
                    "?reset=true" + "\">Reset</a>");

        }
    }
}




