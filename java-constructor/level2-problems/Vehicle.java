public class Vehicle {
    // Instance variables to store vehicle owner name and type
    private String ownerName;
    private String vehicleType;

    // Static variable for registration fee (shared among all vehicles)
    private static int registrationFee = 999;

    // Constructor to initialize vehicle details
    Vehicle(String ownerName, String vehicleType) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    // Method to display vehicle details
    public void displayVehicleDetails() {
        System.out.println("Vehicle owner name : " + ownerName);
        System.out.println("Vehicle type : " + vehicleType);
        System.out.println("Vehicle registration fees : " + registrationFee);
    }

    // Static method to update registration fee
    public static void updateRegistrationFee(int updateFee) {
        registrationFee = updateFee;
        System.out.println("Updated Registration fees : " + registrationFee);
    }

    // Main method to test the class functionality
    public static void main(String[] args) {
        // Creating a new Vehicle object
        Vehicle v = new Vehicle("Alok", "BMW");

        // Displaying vehicle details
        v.displayVehicleDetails();

        // Updating the registration fee
        Vehicle.updateRegistrationFee(1200);

        // Displaying details again to check the updated fee
        v.displayVehicleDetails();
    }
}