<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <style>

        </style>
    </head>

    <body>
        <div class="w3-bar w3-red w3-card w3-padding" id="myNavbar">
            <a href="adminl.jsp" class="w3-bar-item w3-button w3-wide" style="text-decoration-line:none"><b>
                    Ticketing</b></a>

            <div class="w3-right w3-hide-small">
                <a href="AboutUs.aspx" class="w3-bar-item w3-button"><i class="fa fa-user"></i> About Us</a>
                <a href="index.html" class="w3-bar-item w3-button"><i class="fa fa-sign-in"></i> Logout</a>
            </div>
        </div>

        <br> 

        <br> <br> 

        <div class="w3-row-padding w3-theme">



            <div class="w3-third w3-section">
                <div class="w3-card-4">
                    <div class="w3-container w3-center">
                        <h3><b>View Movies</b></h3></div>
                    <a href="viewmovies.jsp">
                        <img src="images/viewimage.jpg" style="width:100%"></a>
                    <div class="w3-container w3-white">
                    </div>
                </div>
            </div>

            <div class="w3-third w3-section">
                <div class="w3-card-4">
                    <div class="w3-container w3-center">
                        <h3><b>Buy</b></h3></div>
                    <a href="buy.jsp">
                        <img src="images/buy.jpg" style="width:100%"></a>
                    <div class="w3-container w3-white">
                    </div>
                </div>
            </div>

        </div>

    </body>
</html>