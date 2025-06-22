import java.util.Scanner;
import myPackage.InventoryManagementSystem;
import myPackage.Product;

public class Problem1 {
    public static void main(String[] args) {
        InventoryManagementSystem inventory = new InventoryManagementSystem();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nInventory Management System");
            System.out.println("1. Add Product");
            System.out.println("2. Update Product");
            System.out.println("3. Delete Product");
            System.out.println("4. Display Inventory");
            System.out.println("5. Search Product");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == 1) {
                System.out.print("Enter Product ID: ");
                int id = Integer.parseInt(scanner.nextLine());
                System.out.print("Enter Product Name: ");
                String name = scanner.nextLine();
                System.out.print("Enter Category: ");
                String category = scanner.nextLine();
                System.out.print("Enter Quantity: ");
                int quantity = Integer.parseInt(scanner.nextLine());
                System.out.print("Enter Price: ");
                double price = Double.parseDouble(scanner.nextLine());
                inventory.addProduct(new Product(id, name, category, quantity, price));
                System.out.println("Product added successfully.");
            } else if (choice == 2) {
                System.out.print("Enter Product ID to update: ");
                int id = Integer.parseInt(scanner.nextLine());
                System.out.print("Enter new Quantity: ");
                int quantity = Integer.parseInt(scanner.nextLine());
                System.out.print("Enter new Price: ");
                double price = Double.parseDouble(scanner.nextLine());
                inventory.updateProduct(id, quantity, price);
                System.out.println("Product updated successfully.");
            } else if (choice == 3) {
                System.out.print("Enter Product ID to delete: ");
                int id = Integer.parseInt(scanner.nextLine());
                inventory.deleteProduct(id);
                System.out.println("Product deleted successfully.");
            } else if (choice == 4) {
                System.out.println("\nCurrent Inventory:");
                inventory.displayInventory();
            } else if (choice == 5) {
                System.out.print("Enter Product ID to search: ");
                int id = Integer.parseInt(scanner.nextLine());
                Product found = inventory.findProduct(id);
                System.out.println(found != null ? found : "Product not found.");
            } else if (choice == 6) {
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid option. Try again.");
            }
        }
        scanner.close();
    }


        // Time Complexity:
        // - addProduct: O(1) on all cases, as it appends to the end of the ArrayList
        // - updateProduct: O(n) 
        // - deleteProduct: O(n) 
        // - displayInventory: O(n) where n is the number of products in the inventory
}
