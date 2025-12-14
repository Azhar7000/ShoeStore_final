package main.java.com.example;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

import main.java.entity.Product;
import main.java.entity.ProductDAO;

@WebServlet("/products")
public class ProductReadServlet extends HttpServlet {

    private ProductDAO dao = new ProductDAO();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setAttribute("products", dao.getAll());
        req.getRequestDispatcher("product_read.jsp").forward(req, resp);
    }
}

