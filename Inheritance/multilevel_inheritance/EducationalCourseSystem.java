// Base Class: Course
class Course {
    String courseName;
    int duration; // in weeks

    // Constructor
    public Course(String courseName, int duration) {
        this.courseName = courseName;
        this.duration = duration;
    }

    // Method to display course details
    public void displayInfo() {
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration + " weeks");
    }
}

// Subclass: OnlineCourse (Extends Course)
class OnlineCourse extends Course {
    String platform;
    boolean isRecorded;

    // Constructor
    public OnlineCourse(String courseName, int duration, String platform, boolean isRecorded) {
        super(courseName, duration); // Call Course constructor
        this.platform = platform;
        this.isRecorded = isRecorded;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Platform: " + platform);
        System.out.println("Recorded: " + (isRecorded ? "Yes" : "No"));
    }
}

// Subclass: PaidOnlineCourse (Extends OnlineCourse)
class PaidOnlineCourse extends OnlineCourse {
    double fee;
    double discount; // Discount in percentage

    // Constructor
    public PaidOnlineCourse(String courseName, int duration, String platform, boolean isRecorded, double fee,
            double discount) {
        super(courseName, duration, platform, isRecorded); // Call OnlineCourse constructor
        this.fee = fee;
        this.discount = discount;
    }

    // Method to calculate final price after discount
    public double getFinalFee() {
        return fee - (fee * discount / 100);
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Fee: $" + fee);
        System.out.println("Discount: " + discount + "%");
        System.out.println("Final Fee After Discount: $" + getFinalFee());
    }
}

// Main class to test the system
public class EducationalCourseSystem {
    public static void main(String[] args) {
        // Creating Course object
        Course course = new Course("Introduction to Java", 6);

        // Creating OnlineCourse object
        OnlineCourse onlineCourse = new OnlineCourse("Python for Data Science", 8, "Coursera", true);

        // Creating PaidOnlineCourse object
        PaidOnlineCourse paidOnlineCourse = new PaidOnlineCourse("Full Stack Web Development", 12, "Udemy", false, 200,
                20);

        // Displaying Course details
        System.out.println("=== Course Details ===");
        course.displayInfo();

        System.out.println("\n=== Online Course Details ===");
        onlineCourse.displayInfo();

        System.out.println("\n=== Paid Online Course Details ===");
        paidOnlineCourse.displayInfo();
    }
}
