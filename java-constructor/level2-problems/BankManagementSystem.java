// Base class: BankAccount
class BankAccount {
    public String accountNumber; // Public
    protected String accountHolder; // Protected
    private double balance; // Private

    // Constructor to initialize bank account details
    public BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    // Method to deposit money (modifies balance)
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Method to withdraw money (modifies balance with validation)
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient balance.");
        }
    }

    // Getter method for balance (since balance is private)
    public double getBalance() {
        return balance;
    }

    // Method to display account details
    public void displayAccountDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: $" + getBalance());
    }
}

// Subclass: SavingsAccount (Inherits from BankAccount)
class SavingsAccount extends BankAccount {
    private double interestRate; // Private attribute specific to savings account

    // Constructor to initialize savings account details
    public SavingsAccount(String accountNumber, String accountHolder, double balance, double interestRate) {
        super(accountNumber, accountHolder, balance); // Call superclass constructor
        this.interestRate = interestRate;
    }

    // Method to calculate and apply interest
    public void applyInterest() {
        double interest = getBalance() * (interestRate / 100);
        deposit(interest);
        System.out.println("Interest applied: $" + interest);
    }

    // Method to display savings account details
    public void displaySavingsAccountDetails() {
        System.out.println("Savings Account Info");
        System.out.println("Account Number: " + accountNumber); // Accessing public field
        System.out.println("Account Holder: " + accountHolder); // Accessing protected field
        System.out.println("Interest Rate: " + interestRate + "%");
        System.out.println("Balance: $" + getBalance());
    }
}

// Main class: BankManagementSystem
public class BankManagementSystem {
    public static void main(String[] args) {
        // Creating a BankAccount object
        BankAccount account = new BankAccount("123456789", "John Doe", 5000);
        account.displayAccountDetails(); // Display account details
        account.deposit(1000); // Deposit money
        account.withdraw(700); // Withdraw money
        System.out.println("Updated Balance: $" + account.getBalance()); // Display updated balance

        System.out.println();

        // Creating a SavingsAccount object
        SavingsAccount savings = new SavingsAccount("987654321", "Alice Smith", 8000, 5.0);
        savings.displaySavingsAccountDetails(); // Display savings account details
        savings.applyInterest(); // Apply interest
        System.out.println("Updated Balance after Interest: $" + savings.getBalance());
    }
}
