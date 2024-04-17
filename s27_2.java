import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class MyServlet extends HttpServlet
{
public void doGet(HttpServletRequest req, HttpServletResponse res)
throws ServletException, IOException
{
res.setContentType("text/html");
PrintWriter out = res.getWriter();
// Get the current session object, create one if necessary
HttpSession session = req.getSession();
out.println("<HTML><HEAD><TITLE>SessionTimer</TITLE></HEAD>");
out.println("<BODY><H1>Session Timer<</H1>");
// Display the previous timeout
out.println("The previous timeout was " +
session.getMaxInactiveInterval());
out.println("<BR>")
// Set the inactive time interval to 10 minutes (in seconds) 
session.setMaxInactiveInterval(600); 
// Display a message 
response.setContentType("text/html"); 
PrintWriter out = response.getWriter(); 
out.println("<html><body>"); 
out.println("<h3>Session Timeout Changed to 10 Minutes</h3>"); 
out.println("</body></html>");
}
}
