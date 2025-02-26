// Base class: Student
class Student {
    public int rollNumber; // Public
    protected String name; // Protected
    private double CGPA; // Private

    // Constructor to initialize student details
    public Student(int rollNumber, String name, double CGPA) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.CGPA = CGPA;
    }

    // Getter method for CGPA (since CGPA is private)
    public double getCGPA() {
        return CGPA;
    }

    // Setter method for CGPA with validation
    public void setCGPA(double CGPA) {
        if (CGPA >= 0.0 && CGPA <= 10.0) { // Ensuring CGPA is within a valid range
            this.CGPA = CGPA;
        } else {
            System.out.println("Invalid CGPA. Please enter a value between 0.0 and 10.0.");
        }
    }

    // Method to display student details
    public void displayStudentDetails() {
        System.out.println("Student Roll Number: " + rollNumber);
        System.out.println("Student Name: " + name);
        System.out.println("Student CGPA: " + getCGPA()); // Using getter method to access CGPA
    }
}

// Subclass: PostgraduateStudent (Inherits from Student)
class PostgraduateStudent extends Student {
    private String specialization; // Private attribute specific to postgraduate students

    // Constructor to initialize postgraduate student details
    public PostgraduateStudent(int rollNumber, String name, double CGPA, String specialization) {
        super(rollNumber, name, CGPA); // Calling superclass constructor
        this.specialization = specialization;
    }

    // Getter method for specialization
    public String getSpecialization() {
        return specialization;
    }

    // Setter method for specialization
    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    // Method to display postgraduate student details
    public void displayPGStudent() {
        System.out.println("Postgraduate Student Info");
        System.out.println("Postgraduate Roll Number: " + rollNumber); // Accessing public field from parent class
        System.out.println("Postgraduate Name: " + name); // Accessing protected field from parent class
        System.out.println("Postgraduate Specialization: " + specialization); // Accessing private field via method
    }
}

// Main class: UniversityManagementSystem
public class UniversityManagementSystem {
    public static void main(String[] args) {
        // Creating a Student object
        Student student = new Student(1246, "Vicky", 8.5);
        student.displayStudentDetails(); // Display student details
        student.setCGPA(9.2); // Updating CGPA using setter method
        System.out.println("Updated CGPA: " + student.getCGPA()); // Display updated CGPA

        System.out.println();

        // Creating a PostgraduateStudent object
        PostgraduateStudent pgStudent = new PostgraduateStudent(1261, "Alok", 8.8, "Machine Learning");
        pgStudent.displayPGStudent(); // Display postgraduate student details

        // Updating specialization using setter method
        pgStudent.setSpecialization("System Engineering");
        System.out.println("Updated Specialization: " + pgStudent.getSpecialization()); // Display updated specialization
    }
}
