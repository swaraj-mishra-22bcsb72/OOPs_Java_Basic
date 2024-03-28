import java.util.Scanner;

//Bank Account Class
class BankAccount {
    String accType;
    String accHolderName;
    String accNumber;
    double bankBalance;
    String accNominee;

    BankAccount() {
        accType = null;
        accHolderName = null;
        accNumber = null;
        bankBalance = 0.0;
        accNominee = null;
    }

    BankAccount(String accType, String accHolderName, String accNumber, double bankBalance) {
        this.accType = accType;
        this.accHolderName = accHolderName;
        this.accNumber = accNumber;
        this.bankBalance = bankBalance;
    }

    double getAccountBalance() {
        return this.bankBalance;
    }

    String getAccountHolderName() {
        return this.accHolderName;
    }

    void setAccountNominee(String accNominee) {
        this.accNominee = accNominee;
    }

    void displayCustomerDetails() {
        System.out.println("Account Type: " + this.accType + "\nAccount Holder's Name: " + this.accHolderName
                + "\nBank Balance: " + this.bankBalance);
    }

    void updateBankBalance(double bankBalance) {
        this.bankBalance = bankBalance;
        System.out.println("New Bank Balance Updated");
    }

    void creditBalance(double amount) {
        this.bankBalance += amount;
        System.out.println("Your Bank Balance was credited with Rs." + amount);
    }

    void debitBalance(double amount) {
        if (this.bankBalance >= amount) {
            this.bankBalance -= amount;
            System.out.println("Your Bank Balance was debited with Rs." + amount);
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    public void transfer(BankAccount otherAccount, double amount) {
        if (this.bankBalance >= amount) {
            this.debitBalance(amount);
            otherAccount.creditBalance(amount);
        } else {
            System.out.println("Insufficient balance.");
        }
    }
}

class BankAccountDriver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of bank accounts: ");
        int numberOfBankAccounts = scanner.nextInt();
        scanner.nextLine(); 

        BankAccount[] bankAccounts = new BankAccount[numberOfBankAccounts];

        for (int i = 0; i < numberOfBankAccounts; i++) {
            System.out.print("Enter the account type for bank account " + (i + 1) + ": ");
            String accType = scanner.nextLine();

            System.out.print("Enter the account holder name for bank account " + (i + 1) + ": ");
            String accHolderName = scanner.nextLine();

            System.out.print("Enter the account number for bank account " + (i + 1) + ": ");
            String accNumber = scanner.nextLine();

            System.out.print("Enter the bank balance for bank account " + (i + 1) + ": ");
            double bankBalance = scanner.nextDouble();

            bankAccounts[i] = new BankAccount(accType, accHolderName, accNumber, bankBalance);
            scanner.nextLine(); 
        }

        for (int i = 0; i < numberOfBankAccounts; i++) {
            bankAccounts[i].displayCustomerDetails();
        }

        scanner.close();
    }
}
