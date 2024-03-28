//Java Program to add 2 numbers using Command Line Arguments
//Swaraj Mishra

import java.util.Scanner;

class Driver{
	public static void main(String[] args){
		int a = Integer.parseInt(args[0]);
		int b = Integer.parseInt(args[1]);
		System.out.println("Sum is : " + (a+b));
	}
}
