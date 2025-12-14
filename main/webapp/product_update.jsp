<%
    if (session == null || session.getAttribute("user") == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>

<!DOCTYPE html>
<html>
<head>
    <title>Update Product</title>
</head>
<body>

<h2>Update Product</h2>

<form action="product-update" method="post">
    <label>ID:</label>
    <input type="number" name="id" required><br><br>

    <label>Name:</label>
    <input type="text" name="name"><br><br>

    <label>Description:</label>
    <input type="text" name="description"><br><br>

    <label>Color:</label>
    <input type="text" name="color"><br><br>

    <label>Size:</label>
    <input type="number" name="size"><br><br>

    <label>Price:</label>
    <input type="number" step="0.01" name="price"><br><br>

    <input type="submit" value="Update Product">
</form>

<br>
<a href="product_read.jsp">Back</a>

</body>
</html>
