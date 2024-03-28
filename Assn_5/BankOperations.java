import java.util.Scanner;

interface Depositable {
    void deposit(double amount);
}

interface Withdrawable {
    void withdraw(double amount);
}

class Account implements Depositable, Withdrawable {
    private double balance;

    public void deposit(double amount) {
        this.balance += amount;
        System.out.println("Deposited: " + amount);
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            this.balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient funds");
        }
    }

    public void displayBalance() {
        System.out.println("Current Balance: " + balance);
    }
}

public class BankOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Account account = new Account();

        System.out.print("Enter deposit amount: ");
        double depositAmount = scanner.nextDouble();
        Depositable depositable = account;
        depositable.deposit(depositAmount);

        System.out.print("Enter withdrawal amount: ");
        double withdrawAmount = scanner.nextDouble();
        Withdrawable withdrawable = account;
        withdrawable.withdraw(withdrawAmount);

        System.out.println("Updated Balance:");
        account.displayBalance();

        scanner.close();
    }
}
