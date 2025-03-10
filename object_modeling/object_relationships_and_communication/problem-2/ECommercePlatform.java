import java.util.*;

// Product class representing items sold on the platform
class Product {
    String name;
    double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return name + " ($" + price + ")";
    }
}

// Customer class representing users who place orders
class Customer {
    String name;
    List<Order> orders; // A customer can place multiple orders

    public Customer(String name) {
        this.name = name;
        this.orders = new ArrayList<>();
    }

    // Method to place an order
    public void placeOrder(Order order) {
        orders.add(order);
        System.out.println(name + " placed an order: " + order);
    }

    @Override
    public String toString() {
        return "Customer: " + name;
    }
}

// Order class representing customer purchases
class Order {
    static int orderCounter = 1; // Unique order ID
    int orderId;
    List<Product> products; // An order contains multiple products
    
    public Order() {
        this.orderId = orderCounter++;
        this.products = new ArrayList<>();
    }

    // Method to add a product to the order
    public void addProduct(Product product) {
        products.add(product);
    }

    @Override
    public String toString() {
        return "Order ID: " + orderId + ", Products: " + products;
    }
}

// Main class to test the e-commerce system
public class ECommercePlatform {
    public static void main(String[] args) {
        // Create some products
        Product p1 = new Product("Laptop", 1200.99);
        Product p2 = new Product("Smartphone", 699.49);
        Product p3 = new Product("Headphones", 149.99);

        // Create a customer
        Customer customer = new Customer("Aditi");

        // Create an order and add products
        Order order1 = new Order();
        order1.addProduct(p1);
        order1.addProduct(p2);

        // Customer places an order
        customer.placeOrder(order1);

        // Create another order
        Order order2 = new Order();
        order2.addProduct(p3);

        // Customer places another order
        customer.placeOrder(order2);
    }
}
