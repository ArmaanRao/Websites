import java.util.*;
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
public class FormServlet extends HttpServlet{
public void doGet(HttpServletRequest request,HttpServletResponse response)
throws ServletException,IOException
{
response.setContentType("text/html");
PrintWriter pw = response.getWriter();
String sal = request.getParameter("sal");
String name = request.getParameter("fname");
String username = request.getParameter("uname");
String pwd = request.getParameter("pwd");
String email = request.getParameter("email");
String dob = request.getParameter("dob");
String[] L = request.getParameterValues("lang");
List lang = Arrays.asList(L);
String AE = request.getParameter("addexp");
pw.println("<html><body>");
pw.println("<head><title>Entered Details</title><link rel='stylesheet' href='style.css'></head>");
pw.println("<h1>Details</h1><table class='center'><tr><th>Salutation: </th><td>"+sal+"</td></tr><tr><th>Name: </th><td>"+name+"</td></tr><tr><th>Username: </th><td>" + username + "</td></tr><tr><th>Password: </th><td>" + pwd + "</td></tr><tr><th>E - mail: </th><td>" + email + "</td></tr><tr><th>DOB: </th><td>" + dob + "</td></tr><tr><th>Languages: </th><td>" + lang + "</td></tr><tr><th>Additional Expertise: </th><td>" + AE + "</td></tr></table>");
pw.println("</body></html>");

pw.close();
}}
