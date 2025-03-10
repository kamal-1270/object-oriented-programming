
// Main class to test polymorphism
public class EmployeeManagement {
    public static void main(String[] args) {
        // Creating different types of employees
        Employee manager = new Manager("Aditi", 101, 80000, 10);
        Employee developer = new Developer("Aanand", 102, 60000, "Java");
        Employee intern = new Intern("Angad", 103, 20000, 6);

        // Storing them in an array for polymorphism
        Employee[] employees = {manager, developer, intern};

        // Loop to display details
        for (Employee emp : employees) {
            emp.displayDetails();
            System.out.println("--------------------------");
        }
    }
}

// Superclass: Employee
class Employee {
    String name;
    int id;
    double salary;

    // Constructor
    public Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    // Method to be overridden by subclasses
    public void displayDetails() {
        System.out.println("ID: " + id + ", Name: " + name + ", Salary: $" + salary);
    }
}

// Subclass: Manager
class Manager extends Employee {
    int teamSize;

    // Constructor
    public Manager(String name, int id, double salary, int teamSize) {
        super(name, id, salary); // Call Employee constructor
        this.teamSize = teamSize;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Role: Manager, Team Size: " + teamSize);
    }
}

// Subclass: Developer
class Developer extends Employee {
    String programmingLanguage;

    // Constructor
    public Developer(String name, int id, double salary, String programmingLanguage) {
        super(name, id, salary);
        this.programmingLanguage = programmingLanguage;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Role: Developer, Programming Language: " + programmingLanguage);
    }
}

// Subclass: Intern
class Intern extends Employee {
    int duration; // Internship duration in months

    // Constructor
    public Intern(String name, int id, double salary, int duration) {
        super(name, id, salary);
        this.duration = duration;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Role: Intern, Duration: " + duration + " months");
    }
}
