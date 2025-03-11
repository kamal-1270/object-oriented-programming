

// Main class
import java.util.*;
public class EmployeeManagementSystem {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        
        FullTimeEmployee emp1 = new FullTimeEmployee(101, "Vicky", 50000, 70000);
        emp1.assignDepartment("HR");
        
        PartTimeEmployee emp2 = new PartTimeEmployee(102, "Deepak", 20000, 20, 500);
        emp2.assignDepartment("IT");
        
        employees.add(emp1);
        employees.add(emp2);
        
        for (Employee emp : employees) {
            emp.displayDetails();
            if (emp instanceof Department) {
                System.out.println(((Department) emp).getDepartmentDetails());
            }
            System.out.println("---------------------------");
        }
    }
}

// Abstract class Employee
abstract class Employee {
    private int employeeId;
    private String name;
    private double baseSalary;
    
    public Employee(int employeeId, String name, double baseSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.baseSalary = baseSalary;
    }
    
    public int getEmployeeId() {
        return employeeId;
    }
    
    public String getName() {
        return name;
    }
    
    public double getBaseSalary() {
        return baseSalary;
    }
    
    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }
    
    public abstract double calculateSalary();
    
    public void displayDetails() {
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Name: " + name);
        System.out.println("Base Salary: " + baseSalary);
        System.out.println("Final Salary: " + calculateSalary());
    }
}

// Interface Department
interface Department {
    void assignDepartment(String departmentName);
    String getDepartmentDetails();
}

// Full-time Employee subclass
class FullTimeEmployee extends Employee implements Department {
    private String department;
    private double fixedSalary;
    
    public FullTimeEmployee(int employeeId, String name, double baseSalary, double fixedSalary) {
        super(employeeId, name, baseSalary);
        this.fixedSalary = fixedSalary;
    }
    
    @Override
    public double calculateSalary() {
        return fixedSalary;
    }
    
    @Override
    public void assignDepartment(String departmentName) {
        this.department = departmentName;
    }
    
    @Override
    public String getDepartmentDetails() {
        return "Department: " + department;
    }
}

// Part-time Employee subclass
class PartTimeEmployee extends Employee implements Department {
    private String department;
    private int hoursWorked;
    private double hourlyRate;
    
    public PartTimeEmployee(int employeeId, String name, double baseSalary, int hoursWorked, double hourlyRate) {
        super(employeeId, name, baseSalary);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }
    
    @Override
    public double calculateSalary() {
        return hoursWorked * hourlyRate;
    }
    
    @Override
    public void assignDepartment(String departmentName) {
        this.department = departmentName;
    }
    
    @Override
    public String getDepartmentDetails() {
        return "Department: " + department;
    }
}
