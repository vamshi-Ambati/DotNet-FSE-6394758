import java.util.Scanner;
import myPackage.Task;
import myPackage.TaskManagementSystem;

public class Problem5 {
    public static void main(String[] args) {
        TaskManagementSystem taskManagement = new TaskManagementSystem();
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("\nTask Management System");
                System.out.println("1. Add Task");
                System.out.println("2. Display All Tasks");
                System.out.println("3. Search Task by ID");
                System.out.println("4. Delete Task by ID");
                System.out.println("5. Exit");
                System.out.print("Choose an option: ");
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1 -> {
                        System.out.print("Enter Task ID: ");
                        int id = Integer.parseInt(scanner.nextLine());
                        System.out.print("Enter Task Name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter Task Status: ");
                        String status = scanner.nextLine();
                        taskManagement.addTask(id, name, status);
                        System.out.println("Task added successfully.");
                    }
                    case 2 -> {
                        System.out.println("\nAll Tasks:");
                        taskManagement.displayTasks();
                    }
                    case 3 -> {
                        System.out.print("Enter Task ID to search: ");
                        int searchId = Integer.parseInt(scanner.nextLine());
                        Task found = taskManagement.searchTask(searchId);
                        System.out.println(found != null ? found : "Task not found");
                    }
                    case 4 -> {
                        System.out.print("Enter Task ID to delete: ");
                        int deleteId = Integer.parseInt(scanner.nextLine());
                        taskManagement.deleteTask(deleteId);
                        System.out.println("Task deleted successfully.");
                    }
                    case 5 -> System.out.println("Exiting...");
                    default -> System.out.println("Invalid option. Try again.");
                }
                if (choice == 5) {
                    break;
                }
            }
        }
    }

    // Time Complexity:
    // - addTask: O(n) in the worst case (if adding at the end of the list)
    // - searchTask: O(n) in the worst case (if searching through the entire list)
    // - deleteTask: O(n) in the worst case (if deleting from the end or not found)
    // - displayTasks: O(n) as it traverses the entire list
}
