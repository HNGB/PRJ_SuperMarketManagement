<%-- 
    Document   : viewCart
    Created on : Mar 10, 2022, 5:48:05 PM
    Author     : lehad
--%>

<%@page import="sample.product.ProductDTO"%>
<%@page import="sample.product.Cart"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Vegetable Farm</title>
    </head>
    <body>
        <h1>Your selected vegetable:</h1>

        <%
            Cart cart = (Cart) session.getAttribute("CART");
            if (cart != null) {
                if (cart.getCart().size() > 0) {
        %>
        <table border="1">
            <thead>
                <tr>
                    <th>No</th>
                    <th>Product ID</th>
                    <th>Product Name</th>
                    <th>Price</th>
                    <th>Quantity</th>
                    <th>Category ID</th>
                    <th>Total</th>
                    <th>Remove</th>
                    <th>Edit</th>
                </tr>
            </thead>
            <tbody>
                <%
                    int count = 1;
                    double total = 0;
                    for (ProductDTO product : cart.getCart().values()) {
                        total += product.getPrice() * product.getQuantity();
                %>
            <form action="MainController">

                <tr>
                    <td><%= count++%></td>
                    <td>
                        <%= product.getProductID()%>
                        <input type="hidden" name="productID" value="<%= product.getProductID()%>"/>
                    </td>
                    <td><%= product.getProductName()%></td>
                    <td><%= product.getPrice()%></td>
                    <td>
                        <input type="number" name="quantity" value="<%= product.getQuantity()%>" min="1" required=""/>
                    </td>
                    <td><%= product.getCategoryID()%></td>
                    <td><%= product.getPrice() * product.getQuantity()%></td> 
                    <td>
                        <input type="submit" name="action" value="Remove"/>
                    </td>                   
                    <td>
                        <input type="submit" name="action" value="Edit"/>
                    </td>                   
                </tr>
            </form>
            <%
                }
            %>
        </tbody>
    </table>
    <h1>Total: <%= total%></h1>
    <%
            }
        }
    %>
    <a href="MainController?action=Search&search=">Add More</a>

</body>
</html>
