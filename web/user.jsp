<%-- 
    Document   : user
    Created on : Mar 8, 2022, 6:33:56 PM
    Author     : lehad
--%>

<%@page import="java.util.List"%>
<%@page import="sample.product.ProductDTO"%>
<%@page import="sample.user.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Page</title>
    </head>
    <body>
        
        <%
            UserDTO loginUser = (UserDTO) session.getAttribute("LOGIN_USER");
            if (loginUser == null || !loginUser.getRoleID().equals("US")) {
                response.sendRedirect("login.jsp");
                return;
            }
            String search = request.getParameter("search");
            if (search == null) {
                search = "";
            }
        %>
        <h1> Welcome: <%= loginUser.getFullName()%></h1>
        <h1 style="text-align:center">Supermarket</h1>

        <a href="MainController?action=Search&search=">Home</a></BR>

        <form action="MainController">
            Search<input type="text" name="search" required="" value="<%=search%>"/>
            <input type="submit" name="action" value="Search"/>
        </form>

        <%
            String message = (String) request.getAttribute("MESSAGE");
            if (message == null) {
                message = "";
            }
        %>
        <h1><%= message%></h1>

        <%
            List<ProductDTO> listProduct = (List<ProductDTO>) request.getAttribute("LIST_PRODUCT");
            if (listProduct != null) {
                if (listProduct.size() > 0) {
        %>  
        <form action="MainController">
            <input type="submit" name="action" value="View"/>
        </form></BR>
        <table border="1">
            <thead>
                <tr>
                    <th>No</th>
                    <th>Product ID</th>
                    <th>Product Name</th>
                    <th>Image</th>
                    <th>Price ($)</th>
                    <th>Quantity</th>
                    <th>Category ID</th>
                    <th>Import Date</th>
                    <th>Using Date</th>
                    <th>Quantity To Cart</th>
                    <th>Add To Cart</th>
                </tr>
            </thead>
            <tbody>
                <%
                    int count = 1;
                    for (ProductDTO product : listProduct) {
                %>
            <form action="MainController">
                <tr>
                    <td><%= count++%></td>
                    <td>
                        <input style="text-align: center" type="text" name="productID" value="<%= product.getProductID()%>" readonly=""/>
                    </td>
                    <td>
                        <input style="text-align: center" type="text" name="productName" value="<%= product.getProductName()%>" readonly=""/>
                    </td>
                    <td>
                        <img src="<%= product.getImage()%>" style="width:60px;height:60px;" readonly=""/></td>
                    <td>
                        <input style="text-align: center" type="number" name="price" value="<%= product.getPrice()%>" readonly=""/>
                    </td>
                    <td>
                        <input style="text-align: center" type="number" name="quantity" value="<%= product.getQuantity()%>" readonly=""/>
                    </td>
                    <td>
                        <input style="text-align: center" type="text" name="categoryID" value="<%= product.getCategoryID()%>" readonly=""/>
                    </td>
                    <td>
                        <input style="text-align: center" type="date" name="importDate" value="<%= product.getImportDate()%>" readonly=""/>
                    </td>
                    <td>
                        <input style="text-align: center" type="date" name="usingDate" value="<%= product.getUsingDate()%>" readonly=""/>
                    </td>
                    <td>
                        <input style="text-align: center" type="number" min="1" name="quantity_add" value="1"/>
                    </td>
                    <td style="text-align: center">
                        <input  type="submit" name="action" value="Add"/>
                    </td>
                </tr>

            </form>                         
            <%
                }
            %>
        </tbody>
    </table>
    <%
        String error = (String) request.getAttribute("ERROR");
        if (error == null) {
            error = "";
        }
    %>
    <%= error%>
    <%                }
        }
    %>
    
    <form action="MainController" method="POST" >
        <input type="submit" name="action" value="Logout"/>
    </form>
</body>
</html>
