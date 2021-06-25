package rs.ac.metropolitan.cs230.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import rs.ac.metropolitan.cs230.util.CheckString;

@WebServlet(name = "Servlet1", urlPatterns = {"/Servlet1"})
public class Servlet1 extends HttpServlet {

    CheckString util = new CheckString();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=utf8;");
       
        String enteredName = request.getParameter("ime");
        String enteredLastName = request.getParameter("prezime");
        // index je string zbog mogućnosti da počinje sa 0 čime bi se prva cifra broja indexa izgubila
        String enteredIndex = request.getParameter("index");
        
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet1</title>");
        out.println("</head>");
        out.println("<h2>" + util.welcomeMessage(enteredName, enteredLastName, enteredIndex) + "</h2>");
        out.println("<body>");
        out.print("<a href='Servlet2?ime=" + enteredName + "&prezime=" + enteredLastName + " '>Drugi servlet link</a></br>");
        out.println("</body>");
        out.println("</html>");
    }

}
