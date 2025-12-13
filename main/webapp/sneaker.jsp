<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    // Redirect to login if user not logged in
    if (session == null || session.getAttribute("user") == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>

<!DOCTYPE html>
<html>
<head>
    <title>Order Sneakers</title>
</head>
<body>

<h1>Order Sneakers</h1>

<form action="sneaker-summary.jsp" method="post">
    <label>Shoe Name:</label>
    <input type="text" name="shoeName" required><br><br>

    <label>Unit Price ($):</label>
    <input type="number" name="unitPrice" step="0.01" required><br><br>

    <label>Quantity:</label>
    <input type="number" name="quantity" min="1" required><br><br>

    <input type="submit" value="Submit Order">
</form>

</body>
</html>
