/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package admin;

import com.sun.istack.*;
import com.sun.istack.logging.Logger;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.sql.*;
import java.util.logging.Level;

/**
 *
 * @author Anand Pandey
 */
@WebServlet(name = "addmovie", urlPatterns = {"/addmovie"})
@MultipartConfig(maxFileSize = 16177215)
public class addmovie extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String mname = request.getParameter("movie");
        String dir = request.getParameter("dir");
        String gen = request.getParameter("gen");
        String lan = request.getParameter("lan");
        // String pos = request.getParameter("img");
        InputStream inputStream = null; // input stream of the upload file

        // obtains the upload file part in this multipart request
        Part filePart = request.getPart("photo");
        if (filePart != null) {
            
            // obtains input stream of the upload file
            inputStream = filePart.getInputStream();
        }
        String message;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ejava?autoReconnect=true&useSSL=FALSE", "root", "anand");

            PreparedStatement ps = con.prepareStatement("insert into movie values(?,?,?,?,?)");

            ps.setString(1, mname);
            ps.setString(2, dir);
            ps.setString(3, gen);
            ps.setString(4, lan);

            if (inputStream != null) {
                // fetches input stream of the upload file for the blob column
                ps.setBlob(5, inputStream);
            }

            // sends the statement to the database server
            int row = ps.executeUpdate();
            if (row > 0) {
               request.getRequestDispatcher("adminl.jsp").include(request, response);
            }

        } catch (ClassNotFoundException | SQLException ex) {
            java.util.logging.Logger.getLogger(addmovie.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
