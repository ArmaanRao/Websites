import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class ProfileServlet extends HttpServlet{
public void doGet(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
	// JDBC driver name and database URL
	String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	String DB_URL="jdbc:mysql://localhost/A5";
	// Database credentials
	String USER = "armaan";
	String PASS = "armaan";
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs;
	PrintWriter out = response.getWriter();
	try {

		Class.forName("com.mysql.jdbc.Driver");

		conn = DriverManager.getConnection(DB_URL, USER, PASS);
		stmt = conn.createStatement();
		HttpSession session=request.getSession(false);
		String user=(String)session.getAttribute("user");
		String cssTag = "<link rel='stylesheet' type='text/css' href='styles.css'>";
		String sql;
		sql = "SELECT uname, name, dob, address FROM Profile where uname=\""+user+"\"";
		out.println("<html><head><title>View</title>" + cssTag + "</head><body>");
		out.println("<h1>Welcome "+user+" to the profile page</h1>");

		out.println("<form action=\"http://localhost:8080/profile/LogoutServlet\">");
		out.println("<input class=\"btn\" type=\"submit\" value=\"LOGOUT\">");
		out.println("</form >");

		rs = stmt.executeQuery(sql);
		
		while(rs.next()){

			String uname = rs.getString("uname");
			String name = rs.getString("name");
			String dob = rs.getString("dob");
			String address = rs.getString("address");

			out.println("<div class='view-box'><h1>PROFILE</h1>");
			
			out.println("<table>");
			out.println("<tr><th>Username</th><th>Name</th><th>Date of Birth</th><th>Address</th></tr>");
			out.println("<tr><td>"+uname+"</td><td>"+name+"</td><td>"+dob+"</td><td>"+address+"</td></tr>");
			
		}
		out.println("</table></div>");

		out.println("</body></html>");
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
