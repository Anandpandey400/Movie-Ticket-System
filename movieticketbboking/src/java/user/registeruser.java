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
@WebServlet(name = "registeruser", urlPatterns = {"/registeruser"})
public class registeruser extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        //password and user info
        String n = request.getParameter("usr");
        String pass = request.getParameter("pass");
        //other info
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phn = request.getParameter("phn");
    
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ejava?autoReconnect=true&useSSL=FALSE", "root", "anand");
            PreparedStatement ps = con.prepareStatement("insert into user values(?,?,?,?,?)");

            ps.setString(1, n);
            ps.setString(2, pass);
            ps.setString(3, name);
            ps.setString(4, email);
            ps.setString(5, phn);
            int i = ps.executeUpdate();
            if (i > 0) {
                request.getRequestDispatcher("user.html").include(request, response);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }
}
