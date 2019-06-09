
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.Enumeration;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class Main extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.getWriter().print(" C:\\murach\\test8\\web8-master " + Charset.defaultCharset());

        PrintWriter pr = response.getWriter();

        pr.println("=== Paths ===\n");
        pr.println("Request URL : " + request.getRequestURL());
        pr.println("Request URI : " + request.getRequestURI());
        pr.println("Servlet path : " + request.getServletPath());

        pr.println("\n=== Headers ===\n");
        Enumeration<String> e = request.getHeaderNames();
        while (e.hasMoreElements()) {
            String param = (String) e.nextElement();
            pr.println(param + " : " + request.getHeader(param));
        }

        pr.println("\n=== Parameters ===\n");
        Map<String, String[]> paramsMap = request.getParameterMap();
        for (String key : paramsMap.keySet()) {
            pr.println(key + " : " + request.getParameter(key));
        }

        pr.println("\n=== Session ===\n");
        // returns 0:0:0:0:0:0:0:1 if executed from localhost
        pr.println("Client IP address : " + request.getRemoteAddr());
        pr.println("Session ID : " + request.getRequestedSessionId());
        // Cookie objects the client sent with this request
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                pr.print(cookie.getName() + ";");
            }
        }
        
        response.setContentType("text/html;charset=UTF-8");
      // Allocate a output writer to write the response message into the network socket
      PrintWriter out = response.getWriter();
 
      // Write the response message, in an HTML page
      try {
         out.println("<!DOCTYPE html>");
         out.println("<html><head>");
         out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
         out.println("<title>Hello, World</title></head>");
         out.println("<body>");
         out.println("<h1>Hello, world!</h1>");  // says Hello
         // Echo client's request information
         out.println("<p>Request URI: " + request.getRequestURI() + "</p>");
         out.println("<p>Protocol: " + request.getProtocol() + "</p>");
         out.println("<p>PathInfo: " + request.getPathInfo() + "</p>");
         out.println("<p>Remote Address: " + request.getRemoteAddr() + "</p>");
         // Generate a random number upon each request
         out.println("<p>A Random Number: <strong>" + Math.random() + "</strong></p>");
         out.println("</body>");
         out.println("</html>");
      } finally {
         out.close();  // Always close the output writer
      }
      
                      String my="C:\\"+".txt";
                FileWriter fw = new FileWriter(my);
                fw.write("Demo testas");
                fw.close();

    }
}
