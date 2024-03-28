import java.util.Scanner;

interface Depositable {
    void deposit(double amount);
}

interface Withdrawable {
    void withdraw(double amount);
}

class BankTransactionError extends Exception{
	BankTransactionError(String s){
		super(s);
	}
}

class Account implements Depositable, Withdrawable {
	static final double minBalance = 5000.0;
	static final double maxDeposit = 50000.0;
    private double balance;

    public void deposit(double amount) {
		try{
			if(amount > maxDeposit){
				throw new BankTransactionError("Deposit amount exceeded the maximum allowed amount");
			}
			else{
				this.balance += amount;
				System.out.println("Deposited: " + amount);
			}
		}
		catch(BankTransactionError e){
			System.out.println(e);
		}
    }

    public void withdraw(double amount) {
		try{
			if(amount > balance - minBalance){
				throw new BankTransactionError("Withdrawal failed!! You have to maintain a Minimum Balance");
			}
			else if (balance >= amount) {
				this.balance -= amount;
				System.out.println("Withdrawn: " + amount);
			} else {
				System.out.println("Insufficient funds");
			}
		}
		catch(BankTransactionError e){
			System.out.println(e);
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

		System.out.print("Enter initial deposit amount: ");
        double InitialDepositAmount = scanner.nextDouble();
        Depositable depositable = account;
        depositable.deposit(InitialDepositAmount);
		
        System.out.print("Enter deposit amount: ");
        double depositAmount = scanner.nextDouble();
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
