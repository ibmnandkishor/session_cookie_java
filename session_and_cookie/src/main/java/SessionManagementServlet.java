import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
 
public class SessionManagementServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		
		// Create a session
		HttpSession session = request.getSession();
		
		// Store the username in the session
		session.setAttribute("username", username);
		
		// Set a cookie
		Cookie cookie = new Cookie("username", username);
		response.addCookie(cookie);
		
		response.sendRedirect("WelcomeServlet");
	}
}