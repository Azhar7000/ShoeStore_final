package main.java.entity;

import main.java.core.DB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductDAO implements DAO<Product>
{
    public ProductDAO() {

    }

    List<Product> products;

    /**
     * Get a single product entity by ID
     */
    @Override
    public Optional<Product> get(int id) {
        DB db = DB.getInstance();
        ResultSet rs = null;

        try {
            String sql = "SELECT * FROM product WHERE product_id = ?";
            PreparedStatement stmt = db.getPreparedStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            Product product = null;

            while (rs.next()) {
                product = new Product(
                        rs.getInt("product_id"),
                        rs.getString("product_name"),
                        rs.getString("product_description"),
                        rs.getString("product_color"),
                        rs.getInt("product_size"),
                        rs.getDouble("product_price")
                );
            }

            return Optional.ofNullable(product);

        } catch (SQLException ex) {
            System.err.println(ex.toString());
            return null;
        }
    }

    /**
     * Get all products
     */
    @Override
    public List<Product> getAll() {
        DB db = DB.getInstance();
        ResultSet rs = null;

        products = new ArrayList<>();

        try {
            String sql = "SELECT * FROM product";
            rs = db.executeQuery(sql);

            Product product = null;

            while (rs.next()) {
                product = new Product(
                        rs.getInt("product_id"),
                        rs.getString("product_name"),
                        rs.getString("product_description"),
                        rs.getString("product_color"),
                        rs.getInt("product_size"),
                        rs.getDouble("product_price")
                );
                products.add(product);
            }

            return products;

        } catch (SQLException ex) {
            System.err.println(ex.toString());
            return null;
        }
    }

    /**
     * Insert a new product
     */
    @Override
    public void insert(Product product) {
        DB db = DB.getInstance();

        try {
            String sql = "INSERT INTO product(product_id, product_name, product_description, product_color, product_size, product_price) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = db.getPreparedStatement(sql);

            stmt.setInt(1, product.getProductId());
            stmt.setString(2, product.getProductName());
            stmt.setString(3, product.getProductDescription());
            stmt.setString(4, product.getProductColor());
            stmt.setInt(5, product.getProductSize());
            stmt.setDouble(6, product.getProductPrice());

            int rowInserted = stmt.executeUpdate();

            if (rowInserted > 0) {
                System.out.println("A new product was inserted successfully!");
            }

        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
    }

    /**
     * Update an existing product
     */
    @Override
    public void update(Product product) {
        DB db = DB.getInstance();
        try {
            String sql = "UPDATE product SET product_name=?, product_description=?, product_color=?, product_size=?, product_price=? WHERE product_id=?";
            PreparedStatement stmt = db.getPreparedStatement(sql);

            stmt.setString(1, product.getProductName());
            stmt.setString(2, product.getProductDescription());
            stmt.setString(3, product.getProductColor());
            stmt.setInt(4, product.getProductSize());
            stmt.setDouble(5, product.getProductPrice());
            stmt.setInt(6, product.getProductId());

            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
    }

    /**
     * Delete a product
     */
    @Override
    public void delete(Product product) {
        DB db = DB.getInstance();

        try {
            String sql = "DELETE FROM product WHERE product_id = ?";
            PreparedStatement stmt = db.getPreparedStatement(sql);

            stmt.setInt(1, product.getProductId());

            int rowsDeleted = stmt.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("A product was deleted successfully!");
            }

        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
    }

    /**
     * Get table column names
     */
    @Override
    public List<String> getColumnNames() {
        DB db = DB.getInstance();
        ResultSet rs = null;
        List<String> headers = new ArrayList<>();

        try {
            String sql = "SELECT * FROM product WHERE product_id = -1";
            rs = db.executeQuery(sql);

            ResultSetMetaData rsmd = rs.getMetaData();
            int numberCols = rsmd.getColumnCount();

            for (int i = 1; i <= numberCols; i++) {
                headers.add(rsmd.getColumnLabel(i));
            }

            return headers;

        } catch (SQLException ex) {
            System.err.println(ex.toString());
            return null;
        }
    }
}
