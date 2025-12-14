<%
    if (session == null || session.getAttribute("user") == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>

<!DOCTYPE html>
<html>
<head>
    <title>Delete Product</title>
</head>
<body>

<h2>Delete Product</h2>

<form action="product-delete" method="post">
    <label>Product ID:</label>
    <input type="number" name="id" required><br><br>

    <input type="submit" value="Delete Product">
</form>

<br>
<a href="product_read.jsp">Back</a>

</body>
</html>
