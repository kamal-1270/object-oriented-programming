

import java.util.*;

// Employee class representing an individual employee
class Employee {
    private String name;

    public Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

// Department class representing a department within a company
class Department {
    private String name;
    private List<Employee> employees; // List of employees in the department

    public Department(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
    }

    // Method to add an employee to the department
    public void addEmployee(String employeeName) {
        employees.add(new Employee(employeeName));
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public String getName() {
        return name;
    }

    public String getDepartmentName() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getDepartmentName'");
    }
}

// Company class representing a company that contains multiple departments
class Company {
    private String name;
    private List<Department> departments; // List of departments in the company

    public Company(String name) {
        this.name = name;
        this.departments = new ArrayList<>();
    }

    // Method to add a new department to the company
    public void addDepartment(String departmentName) {
        departments.add(new Department(departmentName));
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public String getName() {
        return name;
    }
}

// Main class to demonstrate composition
public class CompanySystem {
    public static void main(String[] args) {
        // Creating a company
        Company company = new Company("TechCorp");

        // Adding departments to the company
        company.addDepartment("IT");
        company.addDepartment("HR");

        // Adding employees to departments
        company.getDepartments().get(0).addEmployee("Alice"); // Adding Alice to IT department
        company.getDepartments().get(0).addEmployee("Bob"); // Adding Bob to IT department
        company.getDepartments().get(1).addEmployee("Charlie"); // Adding Charlie to HR department

        // Displaying company details
        System.out.println("Company: " + company.getName());
        for (Department dept : company.getDepartments()) {
            System.out.println("  Department: " + dept.getName());
            for (Employee emp : dept.getEmployees()) {
                System.out.println("    Employee: " + emp.getName());
            }
        }

        // Checking instance relationships using instanceof operator
        if (company instanceof Company) {
            System.out.println("company is an instance of Company.");
        }

        for (Department dept : company.getDepartments()) {
            if (dept instanceof Department) {
                System.out.println(dept.getName() + " is a valid Department.");
            }
        }

        for (Employee emp : company.getDepartments().get(0).getEmployees()) {
            if (emp instanceof Employee) {
                System.out.println(emp.getName() + " is an Employee.");
            }
        }

        // Deleting company (all departments and employees get deleted)
        company = null;
        System.gc(); // Request garbage collection (not guaranteed to run immediately)
    }
}
