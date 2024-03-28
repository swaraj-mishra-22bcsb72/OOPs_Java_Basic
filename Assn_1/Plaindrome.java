//Write a java program that will check the number is palindrome or not.

import java.util.Scanner;

class PalindromeNumberCheck {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number: ");
        int n = scanner.nextInt();
		
		int temp = n, rev= 0;
		while (temp != 0) {
			rev = rev*10 + temp%10;
			temp /= 10;
		}
		if (rev == n) {
			System.out.print(rev+ " is a palindrome number");
		}
		else {
			System.out.print(rev+ " is a not a palindrome number");
		}
	}
}		