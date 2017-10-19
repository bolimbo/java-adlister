import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// if use ris loggen in , user is not null
        if( request.getSession().getAttribute("user") != null) {
          response.sendRedirect("/profile");
    } else {
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {


        String username = request.getParameter("username");
        String password = request.getParameter("password");
        boolean validUser;
        validUser = password.equals("p");

        if (validUser) {
            HttpSession session = request.getSession();
            session.setAttribute("user", username);
            response.sendRedirect("/profile");

        } else {
            response.sendRedirect("/login");

        }
    }
}
//        if (validUser) {
//            HttpSession session = request.getSession();
//            session.setAttribute("user", username);
//            response.sendRedirect("/profile");
//        } else {
//            response.sendRedirect("/login");
//        }
//    }

