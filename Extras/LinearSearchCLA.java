import java.util.Scanner;

class Driver{
	public static void main(String[] args){
		int i;
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a number to search : ");
		int key = sc.nextInt();
		
		for (i = 0; i < args.length; i++){
			if (key == Integer.parseInt(args[i])){
				System.out.println("Element found at index "+i);
				break;
			}
		}
		
		if (i == args.length){
			System.out.println("Element is not found ");
		}
	}
}
