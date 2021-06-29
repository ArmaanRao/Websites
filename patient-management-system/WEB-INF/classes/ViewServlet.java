import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.util.*;

import java.sql.*;

public class ViewServlet extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res)
	throws ServletException,IOException
		{
			res.setContentType("text/html");//setting the content type
			PrintWriter pw=res.getWriter();//get the stream to write the data
			pw.println("<html><body>");
			pw.println("<h2>Viewing all Patient Records</h2><hr>");

			try {
				// JDBC driver and database
				final String url = "jdbc:mysql://localhost:3306/hospital";
				final String user = "root";
				final String password = "vanathi21";

				Connection con = DriverManager.getConnection(url, user, password);

				Statement stmt = con.createStatement();
				String sql;
				sql = "SELECT * FROM patient_details";
				ResultSet rs = stmt.executeQuery(sql);
				pw.println("<table cellpadding=10px style='text-align:left'><tbody><tr><th>ID</th><th>Name</th><th>Age</th><th>Gender</th><th>Address</th><th>Marital Status</th><th>Date of Visit</th></tr>");

				while(rs.next())
				{
					int id = rs.getInt("id");
					String name = rs.getString("name");
					int age = rs.getInt("age");
					String gender = rs.getString("gender");
					String address = rs.getString("address");
					String marital_status = rs.getString("marital_status");
					String date = rs.getString("date");

					pw.println("<tr><td>"+id+"</td><td>"+name+"</td><td>"+age+"</td><td>"+gender+"</td><td>"+address+"</td><td>"+marital_status+"</td><td>"+date+"</td></tr>");
				}

				stmt.close();
				con.close();
				
			}
			catch (Exception e){
				pw.println("Error occured"+e);
				e.printStackTrace();
			}
			pw.println("</body></html>");
			pw.close();//closing the stream
			
		}
}
