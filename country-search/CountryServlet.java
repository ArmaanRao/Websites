import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*; 
public class CountryServlet extends HttpServlet {  
  
  public void doGet(HttpServletRequest request, HttpServletResponse response){  
    
    String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    String DB_URL="jdbc:mysql://localhost/A6";

    String USER = "armaan";
    String PASS = "armaan";

    Connection conn = null;
    Statement stmt = null;
    ResultSet rs;
    

    try{  
    PrintWriter out = response.getWriter();
    response.setContentType("text/xml;charset=UTF-8");  
    Class.forName("com.mysql.jdbc.Driver");
    conn = DriverManager.getConnection(DB_URL, USER, PASS);
    stmt = conn.createStatement();
    String sql;
    sql = "SELECT name FROM Country where name like\""+request.getParameter("country")+"%\"";
    rs = stmt.executeQuery(sql);  
    out.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");

    out.append("<List>");
    while(rs.next())
    {
        String country = rs.getString("name");
        out.append("<Country><Name>" + country + "</Name></Country>");
    }
    out.append("</List>");
    rs.close();
    stmt.close();
    conn.close();

 }catch(Exception e){System.out.println(e);}  
  
}  
}  
   