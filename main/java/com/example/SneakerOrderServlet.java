package main.java.com.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/sneaker-order")
public class SneakerOrderServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        // Product info (not hardcoded in JSP)
        String product = "Sneakers";
        double unitPrice = 100.0;

        int qty = Integer.parseInt(request.getParameter("qty"));
        double subtotal = unitPrice * qty;

        double discountRate = 0.0;

        if (qty == 5) {
            discountRate = 0.05;
        } else if (qty == 10) {
            discountRate = 0.10;
        }

        double discountAmount = subtotal * discountRate;
        double total = subtotal - discountAmount;

        request.setAttribute("product", product);
        request.setAttribute("unitPrice", unitPrice);
        request.setAttribute("qty", qty);
        request.setAttribute("subtotal", subtotal);
        request.setAttribute("discountRate", discountRate * 100);
        request.setAttribute("discountAmount", discountAmount);
        request.setAttribute("total", total);

        request.getRequestDispatcher("sneaker-summary.jsp").forward(request, response);
    }
}
