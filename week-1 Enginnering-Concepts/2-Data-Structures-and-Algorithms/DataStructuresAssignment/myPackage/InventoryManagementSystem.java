package myPackage;
import java.util.*;



public class InventoryManagementSystem {
    ArrayList<Product> products = new ArrayList<>();

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void addProduct(Product p) {
        products.add(p);
    }

    public void updateProduct(int productId, int newQuantity, double newPrice) {
        for (Product p : products) {
            if (p.productId == productId) {
                p.quantity = newQuantity;
                p.price = newPrice;
                return;
            }
        }
        System.out.println("Product not found.");
    }

    public void deleteProduct(int productId) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).productId == productId) {
                products.remove(i);
                return;
            }
        }
        System.out.println("Product not found.");
    }

    public Product findProduct(int productId) {
        for (Product p : products) {
            if (p.productId == productId) return p;
        }
        return null;
    }

    public void displayInventory() {
        for (Product p : products) {
            System.out.println(p);
        }
    }
}
