import java.util.*;

// Faculty class (Aggregation - can exist independently)
class Faculty {
    String name;
    
    public Faculty(String name) {
        this.name = name;
    }
    
    @Override
    public String toString() {
        return "Faculty: " + name;
    }
}

// Department class (Composition - belongs to University)
class Department {
    String name;
    
    public Department(String name) {
        this.name = name;
    }
    
    @Override
    public String toString() {
        return "Department: " + name;
    }
}

// University class (Composition with Departments, Aggregation with Faculty)
class University {
    String name;
    private List<Department> departments;
    private List<Faculty> facultyMembers;

    public University(String name) {
        this.name = name;
        this.departments = new ArrayList<>();
        this.facultyMembers = new ArrayList<>();
    }
    
    // Adding a Department (Composition: University owns Departments)
    public void addDepartment(String deptName) {
        departments.add(new Department(deptName));
    }
    
    // Adding a Faculty member (Aggregation: Faculty exists independently)
    public void addFaculty(Faculty faculty) {
        facultyMembers.add(faculty);
    }
    
    public void showDetails() {
        System.out.println("University: " + name);
        System.out.println("Departments:");
        for (Department d : departments) {
            System.out.println("  " + d);
        }
        System.out.println("Faculty Members:");
        for (Faculty f : facultyMembers) {
            System.out.println("  " + f);
        }
    }
}

public class UniversityManagementSystem {
    public static void main(String[] args) {
        // Creating Faculty members (they can exist independently)
        Faculty f1 = new Faculty("Dr. Smith");
        Faculty f2 = new Faculty("Dr. Johnson");
        
        // Creating a University (Composition relationship)
        University uni = new University("Tech University");
        uni.addDepartment("Computer Science");
        uni.addDepartment("Mathematics");
        
        // Adding Faculty members to the University (Aggregation)
        uni.addFaculty(f1);
        uni.addFaculty(f2);
        
        uni.showDetails();
        
        // Deleting University (will delete departments but not faculty)
        uni = null;
        
        System.out.println("\nUniversity deleted. Faculty members still exist:");
        System.out.println(f1);
        System.out.println(f2);
    }
}
