import myPackage.Order;
import myPackage.EcommercePlatformSearchSystem;
import java.util.Scanner;

public class Problem3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of orders: ");
        int n = Integer.parseInt(scanner.nextLine());
        Order[] orders = new Order[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter details for order " + (i + 1) + ":");
            System.out.print("Order ID: ");
            String orderId = scanner.nextLine();
            System.out.print("Customer Name: ");
            String customer = scanner.nextLine();
            System.out.print("Amount: ");
            double amount = Double.parseDouble(scanner.nextLine());
            orders[i] = new Order(orderId, customer, amount);
        }
        EcommercePlatformSearchSystem ePlatformSearchSystem = new EcommercePlatformSearchSystem();
        while (true) {
            System.out.println("\n1. Sort Orders");
            System.out.println("2. Exit");
            System.out.print("Choose an option: ");
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == 1) {
                System.out.print("Enter sort order (ascending/descending): ");
                String sortOrder = scanner.nextLine();
                System.out.print("Enter sorting algorithm (bubble/quick): ");
                String algo = scanner.nextLine();
                ePlatformSearchSystem.sortOrders(orders, sortOrder, algo);
                System.out.println("\nSorted Orders (" + sortOrder + "):");
                for (Order order : orders) {
                    System.out.println(order.toString());
                }
            } else if (choice == 2) {
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid option. Try again.");
            }
        }
        scanner.close();
    }

    // Time Complexity:
    // Bubble sort - O(n^2) in the worst case,
    // Quick sort - O(n log n) in average case, O(n^2) in the worst case.
}