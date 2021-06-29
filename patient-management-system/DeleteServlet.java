import java.io.*;
import java.util.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.*;
public class DeleteServlet extends HttpServlet{
public void doGet(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
	// JDBC driver name and database URL
	String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	String DB_URL="jdbc:mysql://localhost/PMS";

	// Database credentials
	String USER = "sruthi";
	String PASS = "sruthi";
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs;
	PrintWriter out = response.getWriter();
	try {

			response.setContentType("text/html");
			PrintWriter pw = response.getWriter();
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();
			String sql;
			sql = "delete from Patient where id="+request.getParameter("id");
			int i = stmt.executeUpdate(sql);
			String cssTag = "<link rel='stylesheet' type='text/css' href='styles.css'>";
		// Extract data from result set
			out.println("<html><head><title>View</title>" + cssTag + "</head><body>");
			out.println("<h1>RECORD DELETED</h1>");
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