// Base Class: Order
class Order {
    String orderId;
    String orderDate;

    // Constructor
    public Order(String orderId, String orderDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
    }

    // Method to return order status
    public String getOrderStatus() {
        return "Order placed on " + orderDate;
    }

    // Method to display order details
    public void displayOrderDetails() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Order Date: " + orderDate);
    }
}

// Subclass: ShippedOrder (Extends Order)
class ShippedOrder extends Order {
    String trackingNumber;

    // Constructor
    public ShippedOrder(String orderId, String orderDate, String trackingNumber) {
        super(orderId, orderDate); // Call Order constructor
        this.trackingNumber = trackingNumber;
    }

    @Override
    public String getOrderStatus() {
        return super.getOrderStatus() + " | Shipped with Tracking Number: " + trackingNumber;
    }

    @Override
    public void displayOrderDetails() {
        super.displayOrderDetails();
        System.out.println("Tracking Number: " + trackingNumber);
    }
}

// Subclass: DeliveredOrder (Extends ShippedOrder)
class DeliveredOrder extends ShippedOrder {
    String deliveryDate;

    // Constructor
    public DeliveredOrder(String orderId, String orderDate, String trackingNumber, String deliveryDate) {
        super(orderId, orderDate, trackingNumber); // Call ShippedOrder constructor
        this.deliveryDate = deliveryDate;
    }

    @Override
    public String getOrderStatus() {
        return super.getOrderStatus() + " | Delivered on " + deliveryDate;
    }

    @Override
    public void displayOrderDetails() {
        super.displayOrderDetails();
        System.out.println("Delivery Date: " + deliveryDate);
    }
}

// Main class to test the system
public class RetailOrderManagement {
    public static void main(String[] args) {
        // Creating objects for each order type
        Order order = new Order("ORD123", "2025-03-01");
        ShippedOrder shippedOrder = new ShippedOrder("ORD124", "2025-03-02", "TRK56789");
        DeliveredOrder deliveredOrder = new DeliveredOrder("ORD125", "2025-03-03", "TRK98765", "2025-03-05");

        // Displaying order details and statuses
        System.out.println("=== Order Details ===");
        order.displayOrderDetails();
        System.out.println("Status: " + order.getOrderStatus());

        System.out.println("\n=== Shipped Order Details ===");
        shippedOrder.displayOrderDetails();
        System.out.println("Status: " + shippedOrder.getOrderStatus());

        System.out.println("\n=== Delivered Order Details ===");
        deliveredOrder.displayOrderDetails();
        System.out.println("Status: " + deliveredOrder.getOrderStatus());
    }
}

