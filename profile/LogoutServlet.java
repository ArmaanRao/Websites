import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class LogoutServlet extends HttpServlet{
public void doGet(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {

	PrintWriter out = response.getWriter();
	try {
		response.setContentType("text/html"); 
		

		String cssTag = "<link rel='stylesheet' type='text/css' href='styles.css'>";

		out.println("<html><head><title>View</title>" + cssTag + "</head><body>");
		out.println("<h1>Successfully Logged out</h1>");
		HttpSession session = request.getSession(false);
		if(session!=null)
			session.invalidate();
		out.println("</body></html>");

	}
	catch(Exception e) {
		//Handle errors for Class.forName
		e.printStackTrace();
	}
	
}
}
