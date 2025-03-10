

// Main class
import java.util.*;
public class OnlineFoodDelivery {
    public static void main(String[] args) {
        List<FoodItem> order = new ArrayList<>();
        
        VegItem vegPizza = new VegItem("Veg Pizza", 200, 2);
        NonVegItem chickenBurger = new NonVegItem("Chicken Burger", 150, 1);
        
        order.add(vegPizza);
        order.add(chickenBurger);
        
        for (FoodItem item : order) {
            item.getItemDetails();
            System.out.println("Total Price: " + item.calculateTotalPrice());
            
            if (item instanceof Discountable) {
                System.out.println("Discount Details: " + ((Discountable) item).getDiscountDetails());
                System.out.println("Price after Discount (10%): " + ((Discountable) item).applyDiscount(10));
            }
            System.out.println("---------------------------");
        }
    }
}

// Abstract class FoodItem
abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;
    
    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
    
    public String getItemName() {
        return itemName;
    }
    
    public double getPrice() {
        return price;
    }
    
    public int getQuantity() {
        return quantity;
    }
    
    public void getItemDetails() {
        System.out.println("Item: " + itemName);
        System.out.println("Price: " + price);
        System.out.println("Quantity: " + quantity);
    }
    
    public abstract double calculateTotalPrice();
}

// Interface Discountable
interface Discountable {
    double applyDiscount(double discountPercentage);
    String getDiscountDetails();
}

// VegItem class
class VegItem extends FoodItem implements Discountable {
    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }
    
    @Override
    public double calculateTotalPrice() {
        return getPrice() * getQuantity();
    }
    
    @Override
    public double applyDiscount(double discountPercentage) {
        return calculateTotalPrice() * (1 - discountPercentage / 100);
    }
    
    @Override
    public String getDiscountDetails() {
        return "Veg items have a standard discount available.";
    }
}

// NonVegItem class
class NonVegItem extends FoodItem implements Discountable {
    private static final double ADDITIONAL_CHARGE = 50.0; // Extra charge for non-veg items
    
    public NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }
    
    @Override
    public double calculateTotalPrice() {
        return (getPrice() * getQuantity()) + ADDITIONAL_CHARGE;
    }
    
    @Override
    public double applyDiscount(double discountPercentage) {
        return calculateTotalPrice() * (1 - discountPercentage / 100);
    }
    
    @Override
    public String getDiscountDetails() {
        return "Non-veg items include an additional charge of " + ADDITIONAL_CHARGE;
    }
}
