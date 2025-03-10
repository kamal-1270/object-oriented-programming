
// Main class to test the system
public class VehicleManagement {
    public static void main(String[] args) {
        // Creating an ElectricVehicle object
        ElectricVehicle tesla = new ElectricVehicle("Tesla Model S", 250, 100);
        
        // Creating a PetrolVehicle object
        PetrolVehicle mustang = new PetrolVehicle("Ford Mustang", 300, 60);

        // Displaying details and specific behaviors
        System.out.println("=== Electric Vehicle Details ===");
        tesla.displayInfo();
        tesla.charge();

        System.out.println("\n=== Petrol Vehicle Details ===");
        mustang.displayInfo();
        mustang.refuel();
    }
}


// Superclass: Vehicle
class Vehicle {
    String model;
    int maxSpeed;

    // Constructor
    public Vehicle(String model, int maxSpeed) {
        this.model = model;
        this.maxSpeed = maxSpeed;
    }

    // Display vehicle details
    public void displayInfo() {
        System.out.println("Model: " + model);
        System.out.println("Max Speed: " + maxSpeed + " km/h");
    }
}

// Interface: Refuelable
interface Refuelable {
    void refuel(); // Abstract method for refueling
}

// Subclass: ElectricVehicle (inherits from Vehicle)
class ElectricVehicle extends Vehicle {
    int batteryCapacity;

    // Constructor
    public ElectricVehicle(String model, int maxSpeed, int batteryCapacity) {
        super(model, maxSpeed);
        this.batteryCapacity = batteryCapacity;
    }

    // Method to charge the vehicle
    public void charge() {
        System.out.println(model + " is charging. Battery capacity: " + batteryCapacity + " kWh.");
    }

    // Overriding displayInfo() method
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Battery Capacity: " + batteryCapacity + " kWh");
    }
}

// Subclass: PetrolVehicle (inherits from Vehicle and implements Refuelable)
class PetrolVehicle extends Vehicle implements Refuelable {
    int fuelTankCapacity;

    // Constructor
    public PetrolVehicle(String model, int maxSpeed, int fuelTankCapacity) {
        super(model, maxSpeed);
        this.fuelTankCapacity = fuelTankCapacity;
    }

    // Implementing refuel() method from Refuelable interface
    @Override
    public void refuel() {
        System.out.println(model + " is refueling. Fuel tank capacity: " + fuelTankCapacity + " liters.");
    }

    // Overriding displayInfo() method
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Fuel Tank Capacity: " + fuelTankCapacity + " liters");
    }
}
