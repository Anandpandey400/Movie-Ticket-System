/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package user;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.sql.*;

/**
 *
 * @author Anand Pandey
 */
@WebServlet(name = "buy", urlPatterns = {"/buy"})
public class buy extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String name = request.getParameter("movie");
        int seat=Integer.parseInt(request.getParameter("seat"));
        int sn=Integer.parseInt(request.getParameter("ns"));
        int total=sn*seat;

        out.println("<html><title>Payment</title>");
        out.println("<link rel=\"stylesheet\" href=\"https://www.w3schools.com/w3css/4/w3.css\"><body>");
        out.println("<form class=\"w3-container w3-card-4\" action=\"done\" method=\"post\">");
        out.println("<h2 class=\"w3-text-red w3-center\"><b>Payment</b></h2>");
        out.println("<p>");
        out.println(" <label class=\"w3-text-black\"><b>Name on card</b></label>");
        out.println(" <input class=\"w3-input w3-border\" name=\"name\" type=\"text\"></p>");
        out.println("<p><label class=\"w3-text-black\"><b>Card Number</b></label>");
        out.println("<input class=\"w3-input w3-border\" name=\"last\" type=\"number\" id=\"text\" name=\"gg\"</p>");
        out.println(" <p><label class=\"w3-text-black\"><b>CVV</b></label>");
        out.println("  <input class=\"w3-input w3-border\" name=\"last\" type=\"text\"></p>");
        out.println(" <p><label class=\"w3-text-black\"><b>Amount</b></label>");
        out.println("  <input class=\"w3-input w3-border\" name=\"price\" type=\"text\"  value="+total+"></p>");
         out.println("  <input class=\"w3-input w3-border\" name=\"movie\" type=\"hidden\"  value="+name+"></p>");
        out.println("  <p><button class=\"w3-btn w3-red\">Pay</button></p>");
        out.println("</form>");
        out.println("</body></html> ");

    }
}
