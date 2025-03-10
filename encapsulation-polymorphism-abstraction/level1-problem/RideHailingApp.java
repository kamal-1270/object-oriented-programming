

// Main class
import java.util.*;
public class RideHailingApp {
    public static void main(String[] args) {
        List<Vehicle> rides = new ArrayList<>();
        
        Car car = new Car("C001", "John Doe", 15.0);
        Bike bike = new Bike("B001", "Jane Smith", 10.0);
        Auto auto = new Auto("A001", "Mike Johnson", 12.0);
        
        rides.add(car);
        rides.add(bike);
        rides.add(auto);
        
        double distance = 10.0; // Sample ride distance
        
        for (Vehicle ride : rides) {
            ride.getVehicleDetails();
            System.out.println("Fare for " + distance + " km: " + ride.calculateFare(distance));
            
            if (ride instanceof GPS) {
                ((GPS) ride).updateLocation("Downtown");
                System.out.println("Updated Location: " + ((GPS) ride).getCurrentLocation());
            }
            System.out.println("---------------------------");
        }
    }
}

// Abstract class Vehicle
abstract class Vehicle {
    private String vehicleId;
    private String driverName;
    private double ratePerKm;
    
    public Vehicle(String vehicleId, String driverName, double ratePerKm) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
    }
    
    public String getVehicleId() {
        return vehicleId;
    }
    
    public String getDriverName() {
        return driverName;
    }
    
    public double getRatePerKm() {
        return ratePerKm;
    }
    
    public void getVehicleDetails() {
        System.out.println("Vehicle ID: " + vehicleId);
        System.out.println("Driver Name: " + driverName);
        System.out.println("Rate per Km: " + ratePerKm);
    }
    
    public abstract double calculateFare(double distance);
}

// Interface GPS
interface GPS {
    String getCurrentLocation();
    void updateLocation(String newLocation);
}

// Car class
class Car extends Vehicle implements GPS {
    private String currentLocation;
    
    public Car(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
        this.currentLocation = "Unknown";
    }
    
    @Override
    public double calculateFare(double distance) {
        return getRatePerKm() * distance;
    }
    
    @Override
    public String getCurrentLocation() {
        return currentLocation;
    }
    
    @Override
    public void updateLocation(String newLocation) {
        this.currentLocation = newLocation;
    }
}

// Bike class
class Bike extends Vehicle implements GPS {
    private String currentLocation;
    
    public Bike(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
        this.currentLocation = "Unknown";
    }
    
    @Override
    public double calculateFare(double distance) {
        return getRatePerKm() * distance * 0.9; // 10% discount for bikes
    }
    
    @Override
    public String getCurrentLocation() {
        return currentLocation;
    }
    
    @Override
    public void updateLocation(String newLocation) {
        this.currentLocation = newLocation;
    }
}

// Auto class
class Auto extends Vehicle implements GPS {
    private String currentLocation;
    
    public Auto(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
        this.currentLocation = "Unknown";
    }
    
    @Override
    public double calculateFare(double distance) {
        return getRatePerKm() * distance * 1.1; // 10% surcharge for autos
    }
    
    @Override
    public String getCurrentLocation() {
        return currentLocation;
    }
    
    @Override
    public void updateLocation(String newLocation) {
        this.currentLocation = newLocation;
    }
}
