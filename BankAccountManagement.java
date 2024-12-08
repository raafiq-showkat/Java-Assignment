import java.util.ArrayList;
import java.util.List;

// BankAccount class definition
class BankAccount {
    private int accountNumber;
    private String accountHolder;
    private double balance;
    private List<String> transactionHistory;

    // Constructor to initialize bank account
    public BankAccount(int accountNumber, String accountHolder, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
        recordTransaction("Account created with initial balance: $" + initialBalance);
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit amount must be positive.");
            return;
        }
        balance += amount;
        recordTransaction("Deposited $" + amount);
        System.out.println("Deposit successful. Current balance: $" + balance);
    }

    // Withdrawal method with overdraft handling
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
            return;
        }
        if (amount > balance) {
            System.out.println("Error: Insufficient balance. Transaction denied.");
            recordTransaction("Failed withdrawal of $" + amount + " due to insufficient funds");
        } else {
            balance -= amount;
            recordTransaction("Withdrew $" + amount);
            System.out.println("Withdrawal successful. Current balance: $" + balance);
        }
    }

    // Method to check balance
    public double checkBalance() {
        System.out.println("Current balance: $" + balance);
        return balance;
    }

    // Record transaction history
    private void recordTransaction(String transaction) {
        transactionHistory.add(transaction);
    }

    // Display transaction history
    public void displayTransactionHistory() {
        System.out.println("\nTransaction History for " + accountHolder + ":");
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
        System.out.println();
    }
}
public class BankAccountManagement {
    public static void main(String[] args) {
        // Create multiple bank accounts
        BankAccount account1 = new BankAccount(1001, "Mubashir", 500);
        BankAccount account2 = new BankAccount(1002, "Fahad", 1000);

        // Perform transactions for Mubashir
        System.out.println("\nPerforming transactions for Mubashir:");
        account1.deposit(200);
        account1.withdraw(100);
        account1.checkBalance();
        account1.displayTransactionHistory();

        // Perform transactions for Fahad
        System.out.println("\nPerforming transactions for Fahad:");
        account2.withdraw(500);
        account2.deposit(300);
        account2.checkBalance();
        account2.displayTransactionHistory();
    }
}
