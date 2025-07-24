package myPackage;

public class EmployeeManagementSystem {
    Employee[] employees = new Employee[100]; // fixed-size array
    int size = 0;

    public void addEmployee(Employee emp) {
        if (size < employees.length) {
            employees[size++] = emp;
        } else {
            System.out.println("Array is full!");
        }
    }

    public Employee searchEmployee(int empId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].employeeId == empId) {
                return employees[i];
            }
        }
        return null;
    }

    public void deleteEmployee(int empId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].employeeId == empId) {
                for (int j = i; j < size - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                employees[--size] = null;
                return;
            }
        }
        System.out.println("Employee not found.");
    }

    public void displayEmployees() {
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);
        }
    }
}
