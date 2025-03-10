

// Main class
import java.util.*;
public class ECommercePlatform {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        
        Electronics laptop = new Electronics(201, "Laptop", 60000);
        Clothing tshirt = new Clothing(202, "T-Shirt", 1000);
        Groceries apple = new Groceries(203, "Apple", 200);
        
        products.add(laptop);
        products.add(tshirt);
        products.add(apple);
        
        for (Product product : products) {
            product.displayDetails();
            double tax = (product instanceof Taxable) ? ((Taxable) product).calculateTax() : 0;
            System.out.println("Tax: " + tax);
            System.out.println("Final Price: " + (product.getPrice() + tax - product.calculateDiscount()));
            if (product instanceof Taxable) {
                System.out.println(((Taxable) product).getTaxDetails());
            }
            System.out.println("---------------------------");
        }
    }
}

// Abstract class Product
abstract class Product {
    private int productId;
    private String name;
    private double price;
    
    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }
    
    public int getProductId() {
        return productId;
    }
    
    public String getName() {
        return name;
    }
    
    public double getPrice() {
        return price;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
    
    public abstract double calculateDiscount();
    
    public void displayDetails() {
        System.out.println("Product ID: " + productId);
        System.out.println("Name: " + name);
        System.out.println("Price: " + price);
        System.out.println("Discount: " + calculateDiscount());
    }
}

// Interface Taxable
interface Taxable {
    double calculateTax();
    String getTaxDetails();
}

// Electronics class
class Electronics extends Product implements Taxable {
    public Electronics(int productId, String name, double price) {
        super(productId, name, price);
    }
    
    @Override
    public double calculateDiscount() {
        return getPrice() * 0.10; // 10% discount
    }
    
    @Override
    public double calculateTax() {
        return getPrice() * 0.18; // 18% tax
    }
    
    @Override
    public String getTaxDetails() {
        return "Electronics Tax: 18%";
    }
}

// Clothing class
class Clothing extends Product implements Taxable {
    public Clothing(int productId, String name, double price) {
        super(productId, name, price);
    }
    
    @Override
    public double calculateDiscount() {
        return getPrice() * 0.15; // 15% discount
    }
    
    @Override
    public double calculateTax() {
        return getPrice() * 0.05; // 5% tax
    }
    
    @Override
    public String getTaxDetails() {
        return "Clothing Tax: 5%";
    }
}

// Groceries class (No Tax)
class Groceries extends Product {
    public Groceries(int productId, String name, double price) {
        super(productId, name, price);
    }
    
    @Override
    public double calculateDiscount() {
        return getPrice() * 0.05; // 5% discount
    }
}
