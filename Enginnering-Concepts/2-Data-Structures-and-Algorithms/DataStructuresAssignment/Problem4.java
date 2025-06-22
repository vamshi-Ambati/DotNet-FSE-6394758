import myPackage.EmployeeManagementSystem;
import myPackage.Employee;
import java.util.Scanner;

public class Problem4 {
    public static void main(String[] args) {
        EmployeeManagementSystem employeeManagementSystem = new EmployeeManagementSystem();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nEmployee Management System");
            System.out.println("1. Add Employee");
            System.out.println("2. Display All Employees");
            System.out.println("3. Search Employee by ID");
            System.out.println("4. Delete Employee by ID");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == 1) {
                System.out.print("Enter Employee ID: ");
                int id = Integer.parseInt(scanner.nextLine());
                System.out.print("Enter Name: ");
                String name = scanner.nextLine();
                System.out.print("Enter Designation: ");
                String designation = scanner.nextLine();
                System.out.print("Enter Salary: ");
                double salary = Double.parseDouble(scanner.nextLine());
                employeeManagementSystem.addEmployee(new Employee(id, name, designation, salary));
                System.out.println("Employee added successfully.");
            } else if (choice == 2) {
                System.out.println("\nAll Employees:");
                employeeManagementSystem.displayEmployees();
            } else if (choice == 3) {
                System.out.print("Enter Employee ID to search: ");
                int id = Integer.parseInt(scanner.nextLine());
                Employee emp = employeeManagementSystem.searchEmployee(id);
                System.out.println(emp != null ? emp : "Employee not found.");
            } else if (choice == 4) {
                System.out.print("Enter Employee ID to delete: ");
                int id = Integer.parseInt(scanner.nextLine());
                employeeManagementSystem.deleteEmployee(id);
                System.out.println("Employee deleted successfully.");
            } else if (choice == 5) {
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid option. Try again.");
            }
        }
        scanner.close();
    }
}
