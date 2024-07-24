import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
 
public class LogoutServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		
		Cookie cookie = new Cookie("username", "");
		cookie.setMaxAge(0);
		response.addCookie(cookie);
		
		response.sendRedirect("index.html");
	}
}
 