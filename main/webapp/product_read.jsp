<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.*, main.java.entity.Product" %>

<%
    if (session == null || session.getAttribute("user") == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>

<!DOCTYPE html>
<html>
<head>
    <title>Product List</title>
</head>
<body>

<h2>Product List</h2>

<table border="1" cellpadding="5">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Price</th>
    </tr>

    <%
        List<Product> products = (List<Product>) request.getAttribute("products");
        if (products != null) {
            for (Product p : products) {
    %>
    <tr>
        <td><%= p.getProductId() %></td>
        <td><%= p.getProductName() %></td>
        <td>$<%= p.getProductPrice() %></td>
    </tr>
    <%
            }
        }
    %>
</table>

<br>
<a href="product_create.jsp">Add New Product</a><br>
<a href="index.jsp">Back</a>

</body>
</html>
