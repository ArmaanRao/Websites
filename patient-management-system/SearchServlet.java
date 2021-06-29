import java.io.*;
import java.util.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.*;
public class SearchServlet extends HttpServlet{
public void doGet(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
	// JDBC driver name and database URL
	String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	String DB_URL="jdbc:mysql://localhost/PMS";
	// Database credentials
	String USER = "sruthi";
	String PASS = "sruthi";
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs;
	PrintWriter out = response.getWriter();
	try {
		// Register JDBC driver
		Class.forName("com.mysql.jdbc.Driver");
		// Open a connection
		conn = DriverManager.getConnection(DB_URL, USER, PASS);
		// Execute SQL query
		stmt = conn.createStatement();
		String sql;
		sql = "SELECT name, age, id, gender,address,status, dov FROM Patient where id="+request.getParameter("id");
		rs = stmt.executeQuery(sql);
		// Extract data from result set
		
		while(rs.next()){
		//Retrieve by column name
			int id = rs.getInt("id");
			int age = rs.getInt("age");
			String name = rs.getString("name");
			String gender = rs.getString("gender");
			String address = rs.getString("address");
			String status = rs.getString("status");
			String dov = rs.getString("dov");
			//Display values
			String cssTag = "<link rel='stylesheet' type='text/css' href='styles.css'>";
		// Extract data from result set
			out.println("<html><head><title>View</title>" + cssTag + "</head><body>");
			out.println("<h1>SEARCH RESULTS</h1>");
			out.println("<form action=\"http://localhost:8080/pms/homepage.html\">");
			out.println("<input class=\"btn\" type=\"submit\" value=\"HOME\">");
			out.println("</form >");
			out.println("<div class=\"view-box\"><table>");
			out.println("<tr><th>Name</th><th>Age</th><th>ID</th><th>Gender</th><th>Address</th><th>Marital Status</th><th>Date of Visit</th></tr>");
			out.println("<tr><td>"+name+"</td><td>"+age+"</td><td>"+id+"</td><td>"+gender+"</td><td>"+address+"</td><td>"+status+"</td><td>"+dov+"</td></tr>");
			out.println("</table></div></body></html>");
		}
		out.println("</table></body></html>");
		// Clean-up environment
		rs.close();
		stmt.close();
		conn.close();
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
