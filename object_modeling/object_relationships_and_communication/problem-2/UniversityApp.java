import java.util.*;

// Course class representing a university course
class Course {
    String courseName;
    Professor professor; // A course has one professor (Aggregation)
    List<Student> students; // Many students can enroll in a course

    public Course(String courseName) {
        this.courseName = courseName;
        this.students = new ArrayList<>();
    }

    // Assign a professor to this course
    public void assignProfessor(Professor professor) {
        this.professor = professor;
        System.out.println(professor.name + " is assigned to " + courseName);
    }

    // Enroll a student in the course
    public void enrollStudent(Student student) {
        students.add(student);
        student.enrollCourse(this);
        System.out.println(student.name + " enrolled in " + courseName);
    }

    @Override
    public String toString() {
        return "Course: " + courseName + ", Professor: " + (professor != null ? professor.name : "None") + ", Students: " + students;
    }
}

// Student class representing university students
class Student {
    String name;
    List<Course> courses; // A student can enroll in multiple courses

    public Student(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }

    // Method to enroll in a course
    public void enrollCourse(Course course) {
        if (!courses.contains(course)) {
            courses.add(course);
        }
    }

    @Override
    public String toString() {
        return name;
    }
}

// Professor class representing university professors
class Professor {
    String name;

    public Professor(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Professor: " + name;
    }
}

// Main class for testing the university management system
public class UniversityApp {
    public static void main(String[] args) {
        // Create students
        Student s1 = new Student("Aditi");
        Student s2 = new Student("Tara");

        // Create professors
        Professor p1 = new Professor("Dr. Smith");
        Professor p2 = new Professor("Dr. Johnson");

        // Create courses
        Course c1 = new Course("Computer Science");
        Course c2 = new Course("Mathematics");

        // Assign professors to courses
        c1.assignProfessor(p1);
        c2.assignProfessor(p2);

        // Enroll students in courses
        c1.enrollStudent(s1);
        c1.enrollStudent(s2);
        c2.enrollStudent(s1);
    }
}

