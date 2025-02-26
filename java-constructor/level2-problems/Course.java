public class Course {
    // Instance variables to store course details
    private String courseName;  //private
    private int duration;
    private int fee;
    
    // Class variable common to all instances
    private static String instituteName = "Chitkara University";

    // Constructor to initialize course details
    public Course(String courseName, int duration, int fee) {
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;
    }

    // Instance method to display course details
    public void displayCourseDetail() {
        System.out.println("Course Name: " + courseName);
        System.out.println("Course Duration: " + duration + " months");
        System.out.println("Course Fee: " + fee);
        System.out.println("Institute Name: " + instituteName);
    }

    // Class method to update the institute name
    public static void updateInstituteName(String newInstituteName) {
        instituteName = newInstituteName;
        System.out.println("Updated Institute Name: " + instituteName);
    }

    public static void main(String[] args) {
        // Creating an object of Course class
        Course c = new Course("B.E", 12, 4500);
        
        // Displaying initial course details
        c.displayCourseDetail();
        
        // Updating institute name using class method
        Course.updateInstituteName("Chandigh University");
        
        // Displaying updated course details
        c.displayCourseDetail();
    }
}
