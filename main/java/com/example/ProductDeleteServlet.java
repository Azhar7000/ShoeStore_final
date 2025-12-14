package main.java.com.example;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import main.java.entity.Product;
import main.java.entity.ProductDAO;

import java.io.IOException;

@WebServlet("/product-delete")
public class ProductDeleteServlet extends HttpServlet {

    private ProductDAO dao = new ProductDAO();

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Product p = new Product();
        p.setProductId(Integer.parseInt(req.getParameter("id")));
        dao.delete(p);
        resp.sendRedirect("product_read.jsp");
    }
}
