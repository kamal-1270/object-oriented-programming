
// Main class to test the system
public class RestaurantManagement {
    public static void main(String[] args) {
        // Creating objects of Chef and Waiter
        Chef chef = new Chef("Gordon Ramsay", 101, "Italian");
        Waiter waiter = new Waiter("John Doe", 202, 5);

        // Displaying details and duties
        System.out.println("=== Chef Details ===");
        chef.displayDetails();
        chef.performDuties();

        System.out.println("\n=== Waiter Details ===");
        waiter.displayDetails();
        waiter.performDuties();
    }
}


// Superclass: Person
class Person {
    String name;
    int id;

    // Constructor
    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    // Display common details
    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
    }
}

// Interface: Worker (for hybrid inheritance)
interface Worker {
    void performDuties();  // Abstract method to be implemented
}

// Subclass: Chef (inherits from Person and implements Worker)
class Chef extends Person implements Worker {
    String specialty;

    // Constructor
    public Chef(String name, int id, String specialty) {
        super(name, id);
        this.specialty = specialty;
    }

    @Override
    public void performDuties() {
        System.out.println("Duties: Preparing " + specialty + " dishes.");
    }
}

// Subclass: Waiter (inherits from Person and implements Worker)
class Waiter extends Person implements Worker {
    int tablesAssigned;

    // Constructor
    public Waiter(String name, int id, int tablesAssigned) {
        super(name, id);
        this.tablesAssigned = tablesAssigned;
    }

    @Override
    public void performDuties() {
        System.out.println("Duties: Serving customers at " + tablesAssigned + " tables.");
    }
}
