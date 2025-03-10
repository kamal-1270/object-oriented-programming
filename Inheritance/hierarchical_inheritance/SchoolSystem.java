
// Main class to test the system
public class SchoolSystem {
    public static void main(String[] args) {
        // Creating different roles in the school
        Teacher teacher = new Teacher("Mr. Sharma", 40, "Mathematics");
        Student student = new Student("Aditi", 16, "10th Grade");
        Staff staff = new Staff("Mrs. Gulati", 35, "Administration");

        // Displaying details and roles
        System.out.println("=== Teacher Details ===");
        teacher.displayDetails();
        teacher.displayRole();

        System.out.println("\n=== Student Details ===");
        student.displayDetails();
        student.displayRole();

        System.out.println("\n=== Staff Details ===");
        staff.displayDetails();
        staff.displayRole();
    }
}


// Superclass: Person
class Person {
    String name;
    int age;

    // Constructor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Method to display common details
    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }

    // Abstract method to be overridden
    public void displayRole() {
        System.out.println("Role: General Person in School");
    }
}

// Subclass: Teacher
class Teacher extends Person {
    String subject;

    // Constructor
    public Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }

    @Override
    public void displayRole() {
        System.out.println("Role: Teacher");
        System.out.println("Teaches: " + subject);
    }
}

// Subclass: Student
class Student extends Person {
    String grade;

    // Constructor
    public Student(String name, int age, String grade) {
        super(name, age);
        this.grade = grade;
    }

    @Override
    public void displayRole() {
        System.out.println("Role: Student");
        System.out.println("Grade: " + grade);
    }
}

// Subclass: Staff
class Staff extends Person {
    String department;

    // Constructor
    public Staff(String name, int age, String department) {
        super(name, age);
        this.department = department;
    }

    @Override
    public void displayRole() {
        System.out.println("Role: Staff Member");
        System.out.println("Department: " + department);
    }
}
