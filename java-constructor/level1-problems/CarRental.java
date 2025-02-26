public class CarRental {
    private String customerName;
    private String carModel;
    private int rentalDays;
    private double dailyRate;

    // Constructor to initialize rental details
    public CarRental(String customerName, String carModel, int rentalDays) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
        this.dailyRate = determineDailyRate(carModel);
    }

    // Method to determine the daily rate based on car model
    private double determineDailyRate(String carModel) {
        switch (carModel.toLowerCase()) {
            case "Honda":
                return 50.0;
            case "suv":
                return 80.0;
            case "luxury":
                return 120.0;
            default:
                return 40.0; // Default rate
        }
    }

    // Method to calculate total cost
    public double calculateTotalCost() {
        return rentalDays * dailyRate;
    }

    // Display rental details
    public void displayRentalDetails() {
        System.out.println("Customer Name: " + customerName);
        System.out.println("Car Model: " + carModel);
        System.out.println("Rental Days: " + rentalDays);
        System.out.println("Daily Rate: " + dailyRate);
        System.out.println("Total Cost: " + calculateTotalCost());
    }

    public static void main(String[] args) {
        CarRental rental = new CarRental("Deepak", "Honda", 7);
        rental.displayRentalDetails();
    }
}
