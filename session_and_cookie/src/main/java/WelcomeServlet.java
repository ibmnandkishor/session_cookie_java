import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
 
public class WelcomeServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		
		Cookie[] cookies = request.getCookies();
		String cookieValue = "";
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("username")) {
				cookieValue = cookie.getValue();
				break;
			}
		}
		
		response.getWriter().println("Welcome, " + username + "!");
		response.getWriter().println("Cookie Value: " + cookieValue);
	}
}