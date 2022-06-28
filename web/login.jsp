<%-- 
    Document   : login
    Created on : Mar 8, 2022, 6:32:05 PM
    Author     : lehad
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <h1>Input your information</h1>
        <form action="MainController" method="POST">
            User ID<input type="text" name="userID" required="" placeholder=""/> </br>
            Password<input type="password" name="password" required="" placeholder=""/> </br>
            <input type="submit" name="action" value="Login"/>
            <input type="reset" value="Reset"/>
        </form>
        <% 
           String error = (String)request.getAttribute("ERROR");
           if(error == null) {
               error = "";
           }
        %>
        <%= error %>
    </body>
</html>
