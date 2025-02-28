import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet2 extends HttpServlet {
    private static final String PREDEFINED_USER = "admin";
    private static final String PREDEFINED_PASS = "password";

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (!isValidName(username)) {
            request.setAttribute("error", "Invalid Name! Must start with a capital letter and have at least 3 characters.");
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return;
        }

        if (PREDEFINED_USER.equals(username) && PREDEFINED_PASS.equals(password)) {
            request.setAttribute("user", username);
            request.getRequestDispatcher("welcome.jsp").forward(request, response);
        } else {
            request.setAttribute("error", "Invalid Username or Password!");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    private boolean isValidName(String name) {
        return name != null && name.matches("[A-Z][a-zA-Z]{2,}");
    }
}