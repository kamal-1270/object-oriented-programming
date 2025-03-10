

// Main class
import java.util.*;
public class VehicleRentalSystem {
    public static void main(String[] args) {
        List<Vehicle> vehicles = new ArrayList<>();
        
        Car car = new Car("CAR123", 1500, "INS12345");
        Bike bike = new Bike("BIKE456", 500);
        Truck truck = new Truck("TRUCK789", 3000, "INS67890");
        
        vehicles.add(car);
        vehicles.add(bike);
        vehicles.add(truck);
        
        int rentalDays = 5;
        
        for (Vehicle vehicle : vehicles) {
            vehicle.displayDetails();
            double rentalCost = vehicle.calculateRentalCost(rentalDays);
            System.out.println("Rental Cost for " + rentalDays + " days: " + rentalCost);
            
            if (vehicle instanceof Insurable) {
                double insuranceCost = ((Insurable) vehicle).calculateInsurance();
                System.out.println("Insurance Cost: " + insuranceCost);
                System.out.println(((Insurable) vehicle).getInsuranceDetails());
            }
            System.out.println("---------------------------");
        }
    }
}

// Abstract class Vehicle
abstract class Vehicle {
    private String vehicleNumber;
    private String type;
    private double rentalRate;
    
    public Vehicle(String vehicleNumber, String type, double rentalRate) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
    }
    
    public String getVehicleNumber() {
        return vehicleNumber;
    }
    
    public String getType() {
        return type;
    }
    
    public double getRentalRate() {
        return rentalRate;
    }
    
    public void setRentalRate(double rentalRate) {
        this.rentalRate = rentalRate;
    }
    
    public abstract double calculateRentalCost(int days);
    
    public void displayDetails() {
        System.out.println("Vehicle Number: " + vehicleNumber);
        System.out.println("Type: " + type);
        System.out.println("Rental Rate: " + rentalRate);
    }
}

// Interface Insurable
interface Insurable {
    double calculateInsurance();
    String getInsuranceDetails();
}

// Car class
class Car extends Vehicle implements Insurable {
    private String insurancePolicyNumber;
    
    public Car(String vehicleNumber, double rentalRate, String insurancePolicyNumber) {
        super(vehicleNumber, "Car", rentalRate);
        this.insurancePolicyNumber = insurancePolicyNumber;
    }
    
    @Override
    public double calculateRentalCost(int days) {
        return days * getRentalRate();
    }
    
    @Override
    public double calculateInsurance() {
        return getRentalRate() * 0.1; // 10% insurance cost
    }
    
    @Override
    public String getInsuranceDetails() {
        return "Car Insurance Policy: Confidential";
    }
}

// Bike class
class Bike extends Vehicle {
    public Bike(String vehicleNumber, double rentalRate) {
        super(vehicleNumber, "Bike", rentalRate);
    }
    
    @Override
    public double calculateRentalCost(int days) {
        return days * getRentalRate();
    }
}

// Truck class
class Truck extends Vehicle implements Insurable {
    private String insurancePolicyNumber;
    
    public Truck(String vehicleNumber, double rentalRate, String insurancePolicyNumber) {
        super(vehicleNumber, "Truck", rentalRate);
        this.insurancePolicyNumber = insurancePolicyNumber;
    }
    
    @Override
    public double calculateRentalCost(int days) {
        return days * getRentalRate() * 1.2; // 20% additional cost for heavy-duty vehicles
    }
    
    @Override
    public double calculateInsurance() {
        return getRentalRate() * 0.15; // 15% insurance cost
    }
    
    @Override
    public String getInsuranceDetails() {
        return "Truck Insurance Policy: Confidential";
    }
}
