import myPackage.Task;
import myPackage.TaskManagementSystem;
import java.util.Scanner;

public class Problem5 {
    public static void main(String[] args) {
        TaskManagementSystem taskManagement = new TaskManagementSystem();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nTask Management System");
            System.out.println("1. Add Task");
            System.out.println("2. Display All Tasks");
            System.out.println("3. Search Task by ID");
            System.out.println("4. Delete Task by ID");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == 1) {
                System.out.print("Enter Task ID: ");
                int id = Integer.parseInt(scanner.nextLine());
                System.out.print("Enter Task Name: ");
                String name = scanner.nextLine();
                System.out.print("Enter Task Status: ");
                String status = scanner.nextLine();
                taskManagement.addTask(id, name, status);
                System.out.println("Task added successfully.");
            } else if (choice == 2) {
                System.out.println("\nAll Tasks:");
                taskManagement.displayTasks();
            } else if (choice == 3) {
                System.out.print("Enter Task ID to search: ");
                int id = Integer.parseInt(scanner.nextLine());
                Task found = taskManagement.searchTask(id);
                System.out.println(found != null ? found : "Task not found");
            } else if (choice == 4) {
                System.out.print("Enter Task ID to delete: ");
                int id = Integer.parseInt(scanner.nextLine());
                taskManagement.deleteTask(id);
                System.out.println("Task deleted successfully.");
            } else if (choice == 5) {
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid option. Try again.");
            }
        }
        scanner.close();
    }

    // Time Complexity:
    // - addTask: O(n) in the worst case (if adding at the end of the list)
    // - searchTask: O(n) in the worst case (if searching through the entire list)
    // - deleteTask: O(n) in the worst case (if deleting from the end or not found)
    // - displayTasks: O(n) as it traverses the entire list
}
