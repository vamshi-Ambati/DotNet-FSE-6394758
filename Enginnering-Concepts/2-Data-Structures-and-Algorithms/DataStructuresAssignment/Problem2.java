import myPackage.EcommercePlatformSearchSystem;
import myPackage.Product;
import java.util.Scanner;

public class Problem2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of products: ");
        int n = Integer.parseInt(scanner.nextLine());
        Product[] products = new Product[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter details for product " + (i + 1) + ":");
            System.out.print("ID: ");
            int id = Integer.parseInt(scanner.nextLine());
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Category: ");
            String category = scanner.nextLine();
            System.out.print("Quantity: ");
            int quantity = Integer.parseInt(scanner.nextLine());
            System.out.print("Price: ");
            double price = Double.parseDouble(scanner.nextLine());
            products[i] = new Product(id, name, category, quantity, price);
        }
        EcommercePlatformSearchSystem ePlatformSearchSystem = new EcommercePlatformSearchSystem();
        while (true) {
            System.out.println("\n1. Search for a product");
            System.out.println("2. Exit");
            System.out.print("Choose an option: ");
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == 1) {
                System.out.print("Enter product name to search: ");
                String searchName = scanner.nextLine();
                System.out.print("Choose search algorithm (linear/binary): ");
                String algo = scanner.nextLine();
                Product found = ePlatformSearchSystem.findProduct(products, searchName, algo);
                System.out.println(algo + " Search: " + (found != null ? found.toString() : "Not Found"));
            } else if (choice == 2) {
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid option. Try again.");
            }
        }
        scanner.close();
    }

    // Time complexity analysis
    // Linear Search: O(1) for best case, O(n) for average and worst case, where n is the number of products
    // Binary Search: O(1) for best, O(log n) for average and worst case, where n is the number of products
    // But the Binary search to be sorted so actually the BinarySearch function will take O(n log n) time to sort the products first, making the overall complexity O(n log n) for the binary search operation.
}
