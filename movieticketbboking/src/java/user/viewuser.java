/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Anand Pandey
 */
@WebServlet(name = "viewuser", urlPatterns = {"/viewuser"})
public class viewuser extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {

            out.println("<html><head>");
            out.println(" <link rel=\"stylesheet\" href=\"https://www.w3schools.com/w3css/4/w3.css\">");
            out.println("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>");
            out.println("<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>");
            out.println(" <link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=Raleway\">");
            out.println("  <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">");
            out.println("  <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">");
            out.println("</head><body>");
            out.println("<div class=\"w3-bar w3-red w3-card w3-padding\" id=\"myNavbar\">");
            out.println(" <a href=\"adminl.jsp\" class=\"w3-bar-item w3-button w3-wide\" style=\"text-decoration-line:none\"><b>\n"
                    + "                     Ticketing</b></a>");
            out.println("  <div class=\"w3-right w3-hide-small\">");
            out.println("   <a href=\"adminl.jsp\" class=\"w3-bar-item w3-button\"><i class=\"fa fa-arrow-circle-left\"></i> Back</a>");
            out.println("  <a href=\"index.html\" class=\"w3-bar-item w3-button\"><i class=\"fa fa-sign-in\"></i> Logout</a>");
            out.println(" </div> </div>");
            out.println("  <div class=\"w3-container w3-padding\">");

            out.println("<h1 align=\"center\">Purchase Details</h1>");

            out.println(" <table class=\"w3-table-all w3-centered\"> <tr  class=\"w3-red\">" + "<td><b>Name</b></td>" +"<td><b>Amount</b></td>" +"<td><b>Movie</b></td></tr>");
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ejava?autoReconnect=true&useSSL=FALSE", "root", "anand");

            Statement stmt = con.createStatement();
            String sql = "select * from purchase ;";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {

                String name = rs.getString("name");
                String amt = rs.getString("amount");
                String movie = rs.getString("movie");
                

                out.println("<tr>" + "<td>" + name + "</td>" +"<td>" + amt + "<td>" + movie + "</td></tr>");

            }
            out.println("</table></body></html>");

            rs.close();
            stmt.close();
            out.close();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(viewuser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(viewuser.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
