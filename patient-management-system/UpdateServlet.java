import java.io.*;
import java.util.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.*;
public class UpdateServlet extends HttpServlet{
public void doGet(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
	// JDBC driver name and database URL
	String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	String DB_URL="jdbc:mysql://localhost/PMS";

	// Database credentials
	String USER = "sruthi";
	String PASS = "sruthi";
	Connection conn = null;
	PreparedStatement stmt = null;
	ResultSet rs;
	PrintWriter out = response.getWriter();
	try {

			response.setContentType("text/html");
			PrintWriter pw = response.getWriter();
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.prepareStatement("update Patient set name=?, age=?, gender=?,address=?,status=?,dov=? WHERE id=?");
			stmt.setString(1, request.getParameter("name"));
			stmt.setString(2, request.getParameter("age"));
			stmt.setString(3, request.getParameter("gender"));
			stmt.setString(4, request.getParameter("address"));
			stmt.setString(5, request.getParameter("status"));
			stmt.setString(6, request.getParameter("dov"));
			stmt.setString(7, request.getParameter("id"));
			int i = stmt.executeUpdate();
			String cssTag = "<link rel='stylesheet' type='text/css' href='styles.css'>";
		// Extract data from result set
			out.println("<html><head><title>View</title>" + cssTag + "</head><body>");
			out.println("<h1>RECORD UPDATED</h1>");
			out.println("<form action=\"http://localhost:8080/pms/ViewServlet\">");
			out.println("<input class=\"btn\" type=\"submit\" value=\"VIEW\">");
			out.println("</form >");
			out.println("</body></html>");
	}
	catch(SQLException se) {
		//Handle errors for JDBC
		se.printStackTrace();
	}
	catch(Exception e) {
		//Handle errors for Class.forName
		e.printStackTrace();
	}
	finally {
		//finally block used to close resources
		try {
			if(stmt!=null)
			stmt.close();
		}
		catch(SQLException se2) {
		} // nothing we can do
		try {
			if(conn!=null)
			conn.close();
		}
		catch(SQLException se) {
			se.printStackTrace();
		} //end finally try
	} //end try
}
}