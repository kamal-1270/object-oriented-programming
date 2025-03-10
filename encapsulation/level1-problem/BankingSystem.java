

// Main class
import java.util.*;
public class BankingSystem {
    public static void main(String[] args) {
        List<BankAccount> accounts = new ArrayList<>();
        
        SavingsAccount savings = new SavingsAccount("SAV123", "Alice", 50000);
        CurrentAccount current = new CurrentAccount("CUR456", "Bob", 20000, 10000);
        
        accounts.add(savings);
        accounts.add(current);
        
        for (BankAccount account : accounts) {
            account.displayAccountDetails();
            System.out.println("---------------------------");
        }
        
        // Demonstrate loan application
        if (current instanceof Loanable) {
            ((Loanable) current).applyForLoan(80000);
        }
    }
}

// Abstract class BankAccount
abstract class BankAccount {
    private String accountNumber;
    private String holderName;
    private double balance;
    
    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }
    
    public String getAccountNumber() {
        return accountNumber;
    }
    
    public String getHolderName() {
        return holderName;
    }
    
    public double getBalance() {
        return balance;
    }
    
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(amount + " deposited successfully.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }
    
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println(amount + " withdrawn successfully.");
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }
    
    public abstract double calculateInterest();
    
    public void displayAccountDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Holder Name: " + holderName);
        System.out.println("Balance: " + balance);
        System.out.println("Interest: " + calculateInterest());
    }
}

// Interface Loanable
interface Loanable {
    boolean applyForLoan(double amount);
    double calculateLoanEligibility();
}

// SavingsAccount class
class SavingsAccount extends BankAccount {
    private static final double INTEREST_RATE = 0.04; // 4% interest rate
    
    public SavingsAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }
    
    @Override
    public double calculateInterest() {
        return getBalance() * INTEREST_RATE;
    }
}

// CurrentAccount class
class CurrentAccount extends BankAccount implements Loanable {
    private static final double INTEREST_RATE = 0.02; // 2% interest rate
    private double overdraftLimit;
    
    public CurrentAccount(String accountNumber, String holderName, double balance, double overdraftLimit) {
        super(accountNumber, holderName, balance);
        this.overdraftLimit = overdraftLimit;
    }
    
    @Override
    public double calculateInterest() {
        return getBalance() * INTEREST_RATE;
    }
    
    @Override
    public boolean applyForLoan(double amount) {
        if (amount <= calculateLoanEligibility()) {
            System.out.println("Loan of " + amount + " approved.");
            return true;
        } else {
            System.out.println("Loan application denied.");
            return false;
        }
    }
    
    @Override
    public double calculateLoanEligibility() {
        return getBalance() * 5 + overdraftLimit; // Loan eligibility based on balance and overdraft
    }
}
