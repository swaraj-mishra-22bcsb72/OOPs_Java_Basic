import java.util.Scanner;

class MyThread extends Thread{
	int num;
	int flag;
	
	MyThread(int num, int flag){
		this.num = num;
		this.flag = flag;
	}
	public void run(){
		if (flag == 1){
			System.out.print("Factors are : ");
			for(int i = 2; i <= num/2; i++){
				if ( num%i == 0 ){
					System.out.print(i + "\t");
				}
			}
			System.out.println();
		}
		else if (flag == 2){
			if(num%2 ==0){
				System.out.println("Number is even");
			}
			else{
				System.out.println("Number is odd");
			}
		}
		else{
			System.out.println("Invalid value for flag");
		}
	}
}
public class PrimeCompositeEvenOddMultiThreading{
	public static void main(String[] args){
		System.out.print("Enter a number: ");
		int num = new Scanner(System.in).nextInt();
		MyThread t1 = new MyThread(num, 1);
		t1.start();
		MyThread t2 = new MyThread(num, 2);
		t2.start();
	}
}