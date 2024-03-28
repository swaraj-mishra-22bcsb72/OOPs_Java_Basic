//Write a java program that will print a number in reverse order. 

import java.util.Scanner;

class ReverseOfANumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number: ");
        int n = scanner.nextInt();
		
		int temp = n, rev= 0;
		while (temp != 0) {
			rev = rev*10 + temp%10;
			temp /= 10;
		}
		System.out.print("Reverse of the number is: "+ rev);
	}
}
		