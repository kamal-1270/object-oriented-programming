
import java.util.*;

// Bank class that allows customers to open accounts
class Bank {
    private String name;
    private List<Customer> customers; // List of customers associated with the bank

    public Bank(String name) {
        this.name = name;
        this.customers = new ArrayList<>(); // Initialize an empty list
    }

    // Method to open an account with an initial deposit
    public void openAccount(Customer customer, double initialDeposit) {
        BankAccount newAccount = new BankAccount(this, customer, initialDeposit);
        customer.addAccount(newAccount); // Add the new account to the customer's list

        // If the customer is not already in the bank's list, add them
        if (!customers.contains(customer)) {
            customers.add(customer);
        }
        System.out.println("Account opened for " + customer.getName() + " at " + name);
    }

    public String getName() {
        return name; // Returns the bank's name
    }
}

class Customer {
    private String name;
    private List<BankAccount> accounts; // Bank accounts owned by the customer

    public String getName() {
        return name;
    }

    public Customer(String name) {
        this.name = name;
        this.accounts = new ArrayList<>(); // Initialize an empty list
    }

    // Method to add an account to the customer's account list
    public void addAccount(BankAccount account) {
        accounts.add(account);
    }

    // Method to display all account balances for the customer
    public void viewBalance() {
        System.out.println("Balances for " + name + ":");
        for (BankAccount account : accounts) {
            System.out.println("Bank: " + account.getBank().getName() + ", Balance: $" + account.getBalance());
        }
    }
}

// This class represents the association between customers and banks
class BankAccount {
    private Bank bank; // Reference to the bank where the account is held
    private Customer customer; // Reference to the customer who owns the account
    private double balance;

    public BankAccount(Bank bank, Customer customer, double balance) {
        this.bank = bank;
        this.customer = customer;
        this.balance = balance;
    }

    // Return the current balance of the account
    public double getBalance() {
        return balance;
    }

    // Return the bank associated with this account
    public Bank getBank() {
        return bank;
    }
}

// Main class to run the program and demonstrate bank-customer-account
// association
public class BankingSystem {
    public static void main(String[] args) {
        Bank bank = new Bank("icici Bank");
        Customer customer = new Customer("Aditi");

        // Opening accounts
        bank.openAccount(customer, 1000.0);
        bank.openAccount(customer, 500.0);

        // Viewing balance
        customer.viewBalance();
    }
}
