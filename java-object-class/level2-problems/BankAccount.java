// package object-oriented-programming.java-object-class.level2-problems;

public class BankAccount {
    String accountHolder;
    int accountNumber;
    int balance;

    // BankAccount(String accountHolder,int accountNumber,int balance){
    //     this.accountHolder=accountHolder;
    //     this.accountNumber=accountNumber;
    //     this.balance=balance;
    // }

    //depositing money method
    public int Deposit(int bal){
        balance += bal;

        return balance;
    }

    //Withdrawing money (only if sufficient balance exists).
    public void Withdrawal(int bal){
        if(bal < 0){
            System.out.println("Your account is Insufficient balance");
        }
        balance -= bal;

        System.out.println("After Withdrawal Amount : "+balance);
    }

    public void display(){
        System.out.println("AccountHolder : "+accountHolder+"\nAccountNumber : "+accountNumber+"\nTotal Amount : "+balance);
    }
    public static void main(String[] args) {
        BankAccount b = new BankAccount();
        b.accountHolder = "Deepak";
        b.accountNumber = 1345678;
        b.balance = 2000;

        b.display();
        System.out.println("Deposit Amount : "+b.Deposit(200));
        b.Withdrawal(1000);

    }
}
