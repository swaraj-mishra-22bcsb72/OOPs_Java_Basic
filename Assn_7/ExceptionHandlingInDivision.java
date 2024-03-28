import java.util.Scanner;

class ExceptionHandlingInDivision {
	public static void main(String[] args){	
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter value for a : ");
        double a = scanner.nextDouble();
		System.out.print("Enter value for b : ");
        double b = scanner.nextDouble();
		
		try{
			if(a == b){
				throw new ArithmeticException("/ by zero");
			}
			else{
				System.out.println("Value of a/a-b = " +(a/(a-b)));
			}
		}
		catch(ArithmeticException e){
			System.out.println(e+"\nPlease give proper inputs next time!!");
		}
	}
}
		