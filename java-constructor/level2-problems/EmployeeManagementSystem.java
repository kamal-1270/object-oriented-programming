// Base class: Employee
class Employee {
    public int employeeID; // Public
    protected String department; // Protected
    private double salary; // Private

    // Constructor to initialize employee details
    public Employee(int employeeID, String department, double salary) {
        this.employeeID = employeeID;
        this.department = department;
        this.salary = salary;
    }

    // Method to modify salary with validation
    public void setSalary(double salary) {
        if (salary > 0) {
            this.salary = salary;
        } else {
            System.out.println("Invalid salary amount. Salary must be positive.");
        }
    }

    // Getter method for salary (since salary is private)
    public double getSalary() {
        return salary;
    }

    // Method to display employee details
    public void displayEmployeeDetails() {
        System.out.println("Employee ID: " + employeeID);
        System.out.println("Department: " + department);
        System.out.println("Salary: $" + getSalary());
    }
}

// Subclass: Manager (Inherits from Employee)
class Manager extends Employee {
    private String teamName; // Private attribute specific to Manager

    // Constructor to initialize manager details
    public Manager(int employeeID, String department, double salary, String teamName) {
        super(employeeID, department, salary); // Call superclass constructor
        this.teamName = teamName;
    }

    // Method to display manager details
    public void displayManagerDetails() {
        System.out.println("Manager Details:");
        System.out.println("Employee ID: " + employeeID); // Accessing public field
        System.out.println("Department: " + department); // Accessing protected field
        System.out.println("Team Name: " + teamName);
        System.out.println("Salary: $" + getSalary()); // Accessing private field via method
    }
}

// Main class: EmployeeManagementSystem
public class EmployeeManagementSystem {
    public static void main(String[] args) {
        // Creating an Employee object
        Employee emp = new Employee(101, "IT", 50000);
        emp.displayEmployeeDetails(); // Display employee details
        emp.setSalary(55000); // Updating salary using setter method
        System.out.println("Updated Salary: $" + emp.getSalary());

        System.out.println();

        // Creating a Manager object
        Manager mgr = new Manager(201, "HR", 75000, "Recruitment Team");
        mgr.displayManagerDetails(); // Display manager details
        mgr.setSalary(80000); // Updating salary using setter method
        System.out.println("Updated Manager Salary: $" + mgr.getSalary());
    }
}
