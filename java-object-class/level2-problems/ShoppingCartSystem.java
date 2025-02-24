import java.util.ArrayList;
import java.util.List;

class CartItem {
    String itemName;
    double price;
    int quantity;

    // Constructor
    CartItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    // Method to calculate total price of the item
    public double getTotalPrice() {
        return price * quantity;
    }

    // Method to display item details
    public void displayItem() {
        System.out.println("Item: " + itemName + " | Price: " + price + " | Quantity: " + quantity + " | Total: " + getTotalPrice());
    }
}

class ShoppingCart {
    private List<CartItem> items; // List to store multiple cart items

    // Constructor to initialize the cart
    ShoppingCart() {
        items = new ArrayList<>();
    }

    // Method to add an item to the cart
    public void addItem(String itemName, double price, int quantity) {
        items.add(new CartItem(itemName, price, quantity));
        System.out.println(itemName + " added to the cart.");
    }

    // Method to remove an item from the cart by name
    public void removeItem(String itemName) {
        boolean removed = items.removeIf(item -> item.itemName.equalsIgnoreCase(itemName));
        if (removed) {
            System.out.println(itemName + " removed from the cart.");
        } else {
            System.out.println("Item not found in the cart.");
        }
    }

    // Method to display the cart contents
    public void displayCart() {
        if (items.isEmpty()) {
            System.out.println("The cart is empty.");
        } else {
            System.out.println("\nShopping Cart:");
            for (CartItem item : items) {
                item.displayItem();
            }
            System.out.println("Total Cost: $" + getTotalCost());
        }
        System.out.println("---------------------------");
    }

    // Method to calculate total cart cost
    public double getTotalCost() {
        double total = 0;
        for (CartItem item : items) {
            total += item.getTotalPrice();
        }
        return total;
    }
}

// Main class to test ShoppingCart
public class ShoppingCartSystem {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        // Adding items to the cart
        cart.addItem("Laptop", 50000, 1);
        cart.addItem("Mouse", 1000, 2);
        cart.displayCart();

        // Removing an item
        cart.removeItem("Mouse");
        cart.displayCart();

        // Trying to remove an item that isn't in the cart
        cart.removeItem("Keyboard");
    }
}
