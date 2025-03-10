
// Class representing a Course
import java.util.*;

class Course {
    private String courseName;
    private List<Student> enrolledStudents; // Many-to-Many association with Students

    public Course(String courseName) {
        this.courseName = courseName;
        this.enrolledStudents = new ArrayList<>();
    }

    // Method to enroll a student in this course
    public void enrollStudent(Student student) {
        if (!enrolledStudents.contains(student)) {
            enrolledStudents.add(student);
        }
    }

    // Method to display students enrolled in this course
    public void showEnrolledStudents() {
        System.out.println("Students enrolled in " + courseName + ":");
        for (Student student : enrolledStudents) {
            System.out.println("- " + student.getName());
        }
    }

    public String getCourseName() {
        return courseName;
    }
}

// Class representing a Student
class Student {
    private String name;
    private List<Course> enrolledCourses; // Many-to-Many association with Courses

    public Student(String name) {
        this.name = name;
        this.enrolledCourses = new ArrayList<>();
    }

    // Method to enroll in a course
    public void enrollInCourse(Course course) {
        if (!enrolledCourses.contains(course)) {
            enrolledCourses.add(course);
            course.enrollStudent(this); // Ensuring bidirectional association
        }
    }

    // Method to display courses the student is enrolled in
    public void showEnrolledCourses() {
        System.out.println(name + " is enrolled in:");
        for (Course course : enrolledCourses) {
            System.out.println("- " + course.getCourseName());
        }
    }

    public String getName() {
        return name;
    }
}

// Class representing a School
class School {
    private String schoolName;
    private List<Student> students; // Aggregation relationship with Students

    public School(String schoolName) {
        this.schoolName = schoolName;
        this.students = new ArrayList<>();
    }

    // Method to add a student to the school
    public void addStudent(Student student) {
        students.add(student);
    }

    // Method to display all students in the school
    public void showStudents() {
        System.out.println("Students in " + schoolName + ":");
        for (Student student : students) {
            System.out.println("- " + student.getName());
        }
    }
}

// Main class to demonstrate the functionality
public class SchoolManagementSystem {
    public static void main(String[] args) {
        // Create a school
        School school = new School("KV-4");

        // Create students
        Student student1 = new Student("Aditi");
        Student student2 = new Student("Tara");

        // Add students to the school (Aggregation)
        school.addStudent(student1);
        school.addStudent(student2);

        // Create courses
        Course math = new Course("Mathematics");
        Course science = new Course("Science");

        // Students enroll in courses (Association)
        student1.enrollInCourse(math);
        student1.enrollInCourse(science);
        student2.enrollInCourse(math);

        // Display enrolled courses for students
        student1.showEnrolledCourses();
        student2.showEnrolledCourses();

        // Display students enrolled in a course
        math.showEnrolledStudents();
        science.showEnrolledStudents();

        // Display students in the school
        school.showStudents();
    }
}
