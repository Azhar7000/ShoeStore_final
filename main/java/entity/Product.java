package entity;




public class Product{
    private int productId;
    private String productName;
    private String productDescription;
    private String productColor;
    private int productSize;
    private double productPrice;

    public Product(int productId, String productName, String productDescription, String productColor, int productSize, double productPrice) {
        this.productId = productId;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productColor = productColor;
        this.productSize = productSize;
        this.productPrice = productPrice;
    }

    public int getProductId() {
        return productId;
    }
    public String getProductName() {
        return productName;
    }
    public String getProductDescription() {
        return productDescription;
    }
    public String getProductColor() {
        return productColor;
    }
    public int getProductSize() {
        return productSize;
    }
    public double getProductPrice() {
        return productPrice;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }
    public void setProductColor(String productColor) {
        this.productColor = productColor;
    }
    public void setProductSize(int productSize) {
        this.productSize = productSize;
    }
    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    @Override
    public String toString() {
        return "Products{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", productColor='" + productColor + '\'' +
                ", productSize=" + productSize +
                ", productPrice=" + productPrice +
                '}';
    }
}

