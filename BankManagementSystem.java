abstract class Account {
    String accountHolderName;
    String accountNumber;
    double balance;

    // Constructor for Account class
    public Account(String accountHolderName, String accountNumber, double balance) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // Abstract method to be implemented by subclasses
    public abstract void deposit(double amount);

    // Abstract method to be implemented by subclasses
    public abstract void withdraw(double amount);

    // Concrete method to display account details
    public void displayAccountDetails() {
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: $" + balance);
    }
}

class SavingsAccount extends Account {
    double interestRate;

    // Constructor for SavingsAccount class
    public SavingsAccount(String accountHolderName, String accountNumber, double balance, double interestRate) {
        super(accountHolderName, accountNumber, balance);
        this.interestRate = interestRate;
    }

    // Implementing the deposit method
    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited $" + amount + " into Savings Account. New Balance: $" + balance);
    }

    // Implementing the withdraw method
    @Override
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrew $" + amount + " from Savings Account. New Balance: $" + balance);
        } else {
            System.out.println("Insufficient balance for withdrawal.");
        }
    }

    // Method to calculate interest
    public void calculateInterest() {
        double interest = balance * interestRate / 100;
        System.out.println("Interest Earned: $" + interest);
    }
}

class CurrentAccount extends Account {
    double overdraftLimit;

    // Constructor for CurrentAccount class
    public CurrentAccount(String accountHolderName, String accountNumber, double balance, double overdraftLimit) {
        super(accountHolderName, accountNumber, balance);
        this.overdraftLimit = overdraftLimit;
    }

    // Implementing the deposit method
    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited $" + amount + " into Current Account. New Balance: $" + balance);
    }

    // Implementing the withdraw method
    @Override
    public void withdraw(double amount) {
        if (balance + overdraftLimit >= amount) {
            balance -= amount;
            System.out.println("Withdrew $" + amount + " from Current Account. New Balance: $" + balance);
        } else {
            System.out.println("Overdraft limit exceeded.");
        }
    }
}

public class BankManagementSystem 
{
    public static void main(String[] args) {
        // Create a SavingsAccount object
        SavingsAccount savings = new SavingsAccount("Alice", "SAV123", 1000.0, 3.5);
        System.out.println("Savings Account Details:");
        savings.displayAccountDetails();
        savings.deposit(500);
        savings.withdraw(200);
        savings.calculateInterest();

        // Create a CurrentAccount object
        CurrentAccount current = new CurrentAccount("Bob", "CUR456", 1500.0, 500.0);
        System.out.println("\nCurrent Account Details:");
        current.displayAccountDetails();
        current.deposit(400);
        current.withdraw(1800);
    }
}

