<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%
String driver = "com.mysql.jdbc.Driver";
String connectionUrl = "jdbc:mysql://localhost:3306/ejava?autoReconnect=true&useSSL=FALSE";
String userid = "root";
String password = "anand";
try {
Class.forName(driver);
} catch (ClassNotFoundException e) {
e.printStackTrace();
}
Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
%>
<!DOCTYPE html>
<html>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <body>

        <div class="w3-bar w3-red w3-card w3-padding" id="myNavbar">
            <a href="adminl.jsp" class="w3-bar-item w3-button w3-wide" style="text-decoration-line:none"><b>
                    Ticketing</b></a>

            <div class="w3-right w3-hide-small">
                <a href="adminl.jsp" class="w3-bar-item w3-button"><i class="fa fa-arrow-circle-left"></i> Back</a>
                <a href="index.html" class="w3-bar-item w3-button"><i class="fa fa-sign-in"></i> Logout</a>
            </div>
        </div>


        <div class="w3-container w3-center">
            <h2>Movie Details</h2>

            <table class="w3-table-all">
                <tr class="w3-red">
                    <td>MOVIE NAME</td>
                    <td>DIRECTOR</td>
                    <td>GENRE</td>
                    <td>LANGUAGE</td>

                </tr>
        </div>

        <%
        try{
        connection = DriverManager.getConnection(connectionUrl, userid, password);
        statement=connection.createStatement();
        String sql ="select * from movie";
        resultSet = statement.executeQuery(sql);
        while(resultSet.next()){
        %>
    <tr>
        <td><%=resultSet.getString("moviename") %></td>
        <td><%=resultSet.getString("director") %></td>
        <td><%=resultSet.getString("genre") %></td>
        <td><%=resultSet.getString("language") %></td>

    </tr>
    <%
    }
    connection.close();
    } catch (Exception e) {
    e.printStackTrace();
    }
    %>
</table> 

</body>
</html>