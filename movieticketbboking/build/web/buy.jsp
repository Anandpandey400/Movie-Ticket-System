<%-- 
    Document   : buy
    Created on : Sep 11, 2023, 6:59:25 PM
    Author     : Anand Pandey
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<!DOCTYPE html>
<!--
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Html.html to edit this template
-->
<html>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <form action='buy' method="post">
        <body>

            <div class="w3-bar w3-red w3-card w3-padding" id="myNavbar">
                <a href="adminl.jsp" class="w3-bar-item w3-button w3-wide" style="text-decoration-line:none"><b>
                        Ticketing</b></a>

                <div class="w3-right w3-hide-small">
                    <a href="adminl.jsp" class="w3-bar-item w3-button"><i class="fa fa-arrow-circle-left"></i> Back</a>
                    <a href="index.html" class="w3-bar-item w3-button"><i class="fa fa-sign-in"></i> Logout</a>
                </div>
            </div>
            <br> <br> 

            <div class="w3-container w3-card-4">
                <h2>Choose Movie</h2>
                

                    <%
                        try{
                         Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ejava?autoReconnect=true&useSSL=FALSE", "root", "anand");
                   Statement st=con.createStatement();
                   String query="select * from movie";
                   ResultSet rs=st.executeQuery(query);
           
                   while(rs.next()){
                    %>

                    <p>
                        <input class="w3-radio" type="radio" name="movie" value="<%=rs.getString("moviename")%>" checked>
                        <label><%=rs.getString("moviename")%></label></p>


                    <%
                                }
                    }
                    catch(Exception e){
                
                    }
                
                    %>
                
            </div>
            <br>
            <div class="w3-container w3-card-4">
              
                    <h2>Choose Seat</h2>
                    <p>
                        <input class="w3-radio" type="radio" name="seat" value="250" checked>
                        <label>Front Row (250)</label></p>  
                    <p>
                        <input class="w3-radio" type="radio" name="seat" value="450" checked>
                        <label>Middle Row (450)</label></p>  
                    <p>
                        <input class="w3-radio" type="radio" name="seat" value="650" checked>
                        <label>Recliner Row (650)</label></p>  
                
            </div>
            <br>
            
            
            <div class="w3-container w3-card-4">
              
                    <h2>No.of Seats</h2>
                    <p>
                        
                    <input class="w3-input w3-border w3-sand" name="ns" type="text"></p>
                    
                
            </div>
            <br>

            <div class="w3-container w3-center">
                <div class="w3-bar">
                    <button class="w3-button w3-black ">Pay</button>
                   

                </div>
            </div>




            <br> <h2></h2>

            <footer style=text-align:center;">

                <div class="w3-container w3-red w3-Times">
                    <h2></h2>
                    <p>Author: MAN Ticketing<br>
                        <a href="mailto:">Manticketing@hotmail.com</a> </p>
                    <h2></h2>
                </div>


            </footer>
        </body>
    </form>
</html>
