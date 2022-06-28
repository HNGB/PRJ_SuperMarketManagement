<%-- 
    Document   : admin
    Created on : Mar 8, 2022, 6:36:36 PM
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
        <title>Admin Page</title>
    </head>
    <body>
        <%
            UserDTO loginUser = (UserDTO) session.getAttribute("LOGIN_USER");
            if (loginUser == null || !loginUser.getRoleID().equals("AD")) {
                response.sendRedirect("login.jsp");
                return;
            }
            String search = request.getParameter("search");
            if (search == null) {
                search = "";
            }
        %>
        <h1> Welcome: <%= loginUser.getFullName()%></h1>
        <a href="MainController?action=Admin_Search&search=">Home</a></BR>
        <form action="MainController">
            Search<input type="text" name="search" required="" value="<%= search%>"/>
            <input type="submit" name="action" value="Admin_Search"/></br>            
        </form>
        <form action="MainController">
            <input type="submit" name="action" value="Insert"/>          
        </form></BR>
        <%
            List<ProductDTO> listProduct = (List<ProductDTO>) request.getAttribute("LIST_PRODUCT");
            if (listProduct != null) {
                if (listProduct.size() > 0) {
        %>  
        <table border="1">
            <thead>
                <tr>
                    <th>No</th>
                    <th>Product ID</th>
                    <th>Product Name</th>
                    <th>Image</th>
                    <th>Price</th>
                    <th>Quantity</th>
                    <th>Category ID</th>
                    <th>Import Date</th>
                    <th>Using Date</th>
                    <th>Delete</th>
                    <th>Update</th>

                </tr>
            </thead>
            <tbody>
                <%
                    int count = 1;
                    for (ProductDTO product : listProduct) {
                %>
            <form action="MainController">

                <tr style="text-align: center">
                    <td><%= count++%></td>
                    <td>
                        <input style="text-align: center" type="text" name="productID" value="<%= product.getProductID()%>" required="" readonly=""/>
                    </td>
                    <td>
                        <input style="text-align: center" type="text" name="productName" value="<%= product.getProductName()%>" required=""/>
                    </td>
                    <td><img src="<%= product.getImage()%>" style="width:60px;height:60px;" readonly=""/></td>
                    <td>
                        <input style="text-align: center" type="number" name="price" value="<%= product.getPrice()%>" required=""/>
                    </td>
                    <td>
                        <input style="text-align: center" type="number" name="quantity" value="<%= product.getQuantity()%>" required=""/>
                    </td>
                    <td>
                        <input style="text-align: center" type="text" name="categoryID" value="<%= product.getCategoryID()%>" required=""/>
                    </td>
                    <td>
                        <input style="text-align: center" type="date" name="importDate" value="<%= product.getImportDate()%>" required=""/>
                    </td>
                    <td>
                        <input style="text-align: center" type="date" name="usingDate" value="<%= product.getUsingDate()%>" required=""/>
                    </td>
                    <td>
                        <input type="submit" name="action" value="Delete"/>
                        <input type="hidden" name="search" value="<%= search%>"
                    </td>
                    <td>
                        <input type="submit" name="action" value="Update"/>
                        <input type="hidden" name="search" value="<%= search%>"
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
    <form action="MainController" method="POST">
        <input type="submit" name="action" value="Logout" />
    </form>
</body>
</html>
