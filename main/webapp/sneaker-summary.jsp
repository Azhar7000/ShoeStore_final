<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    // Redirect if user not logged in
    if (session == null || session.getAttribute("user") == null) {
        response.sendRedirect("login.jsp");
        return;
    }

    // Get form input
    String shoeName = request.getParameter("shoeName");
    double unitPrice = Double.parseDouble(request.getParameter("unitPrice"));
    int quantity = Integer.parseInt(request.getParameter("quantity"));

    // Calculate subtotal
    double subtotal = unitPrice * quantity;

    // Discount logic
    double discountRate = 0.0;

    if (quantity == 5) {
        discountRate = 0.05;   // 5%
    } else if (quantity == 10) {
        discountRate = 0.10;   // 10%
    }

    double discountAmount = subtotal * discountRate;
    double total = subtotal - discountAmount;
%>

<!DOCTYPE html>
<html>
<head>
    <title>Product Summary</title>
</head>
<body>

<h1>Product Summary</h1>

<p><strong>Product:</strong> <%= shoeName %></p>
<p><strong>Unit Price:</strong> $<%= unitPrice %></p>
<p><strong>Quantity:</strong> <%= quantity %></p>
<p><strong>Subtotal:</strong> $<%= subtotal %></p>

<p><strong>Discount:</strong>
    <%= (int)(discountRate * 100) %>%
    (-$<%= discountAmount %>)
</p>

<p><strong>Total:</strong> $<%= total %></p>

<br><br>

<a href="sneaker.jsp">Back to Order Page</a>

</body>
</html>
