import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class LoginServlet extends HttpServlet{
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
		String sql;
		sql = "SELECT uname, pwd FROM Login where uname=\""+request.getParameter("username")+"\"";
		rs = stmt.executeQuery(sql);

		String cssTag = "<link rel='stylesheet' type='text/css' href='styles.css'>";

		out.println("<html><head><title>View</title>" + cssTag + "</head><body>");
		if(rs.next()==false){
			out.println("<h1>Username or password does not match.</h1>");
		}
		else{
			String uname = rs.getString("uname");
			String pwd = rs.getString("pwd");
			if(pwd.equals(request.getParameter("passwd")))
			{
				HttpSession session = request.getSession();
				session.setAttribute("user", uname);
				out.println("<h1>Welcome "+uname+"</h1>");
				out.println("<a href='ProfileServlet'>View Profile in Detail</a>");

			}
			else
			{
				out.println("<h1>Username or password does not match.</h1>");
			}
			
		}
		out.println("</body></html>");
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
