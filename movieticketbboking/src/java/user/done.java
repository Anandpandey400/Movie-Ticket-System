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
@WebServlet(name = "done", urlPatterns = {"/done"})
public class done extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String n = request.getParameter("price");
        String m = request.getParameter("movie");
        String g = request.getParameter("name");

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ejava?autoReconnect=true&useSSL=FALSE", "root", "anand");
            PreparedStatement ps = con.prepareStatement("insert into purchase values(?,?,?)");
            ps.setString(1, g);
            ps.setString(2, n);
            ps.setString(3, m);
            int i = ps.executeUpdate();
            if (i > 0) {
                out.println("<html>\n"
                        + "<title>W3.CSS</title>\n"
                        + "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n"
                        + "<link rel=\"stylesheet\" href=\"https://www.w3schools.com/w3css/4/w3.css\">\n"
                        + "<body>\n"
                        + "<br> <br>\n"
                        + "<center>\n"
                        + "<div class=\"w3-container\">\n"
                        + "\n"
                        + "  <div class=\"w3-card-4\" style=\"width:70%\">\n"
                        + "    <header class=\"w3-container w3-red\">\n"
                        + "      <h1>Movie Recipet</h1>\n"
                        + "    </header>\n"
                        + "    <div class=\"w3-container\">\n"
                        + "      <h2> " + m + "</h2>\n"
                        + "      <hr>\n"
                        + "       <p>Name: " + g + "</p>\n"
                        + "       <p>Amount: " + n + "</p>\n"
                        + "     <br>\n"
                        + "    </div>\n"
                        + "    <a href=\"index.html\">\n"
                        + "    <button class=\"w3-button w3-block w3-dark-grey\">Done</button>\n"
                        + "    </a>\n"
                        + "  </div>\n"
                        + "</div>\n"
                        + "</center>\n"
                        + "</body>\n"
                        + "</html>");

            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }
}
