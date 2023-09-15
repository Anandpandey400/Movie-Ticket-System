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
@WebServlet(name = "userlogin", urlPatterns = {"/userlogin"})
public class userlogin extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession();
        String user = request.getParameter("uname");
        session.setAttribute("name", user);
        String pass = request.getParameter("pass");

        try {
             Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ejava?autoReconnect=true&useSSL=FALSE", "root", "anand");
            PreparedStatement pst = con
                    .prepareStatement("Select user,pass from user where user=? and pass=?");
            pst.setString(1, user);
            pst.setString(2, pass);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                request.getRequestDispatcher("userl.jsp").include(request, response);
            } else {
                out.println("<h2></h2>Username or Password incorrect");
                request.getRequestDispatcher("user.html").include(request, response);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
