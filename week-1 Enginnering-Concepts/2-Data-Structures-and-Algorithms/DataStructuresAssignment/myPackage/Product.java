package myPackage;

public class Product {
    int productId;
    String productName;
    String category;
    int quantity;
    double price;

    public Product(int productId, String productName, String category, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
        this.quantity = quantity;
        this.price = price;
    }


    @Override
    public String toString() {
        return productId + " - " + productName + " | Qty: " + quantity + " | ₹" + price;
    }
}
