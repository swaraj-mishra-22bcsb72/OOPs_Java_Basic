import java.util.Scanner;

class ExceptionHandlingInDivisionAndArray {
	public static void main(String[] args){	
		double[] arr = new double[2];
		Scanner scanner = new Scanner(System.in);
		try{
			System.out.print("Enter value for index 1 : ");
			int index1 = scanner.nextInt();
			System.out.print("Enter value for index 2 : ");
			int index2 = scanner.nextInt();
			if (index1 < arr.length && index2 < arr.length){
				System.out.print("Enter value for a : ");
				arr[index1] = scanner.nextDouble();
				System.out.print("Enter value for b : ");
				arr[index2] = scanner.nextDouble();
				try{
					if(arr[index1] == arr[index2]){
						throw new ArithmeticException("/ by zero");
					}
					else{
						System.out.println("Value of a/a-b = " +(arr[index1]/(arr[index1]-arr[index2])));
					}
				}
				catch(ArithmeticException e){
					System.out.println(e+"\nPlease give proper inputs next time!!");
				}
			}
			else{
				throw new ArrayIndexOutOfBoundsException("Input values for index values exceed the array length");
			}
		}
		catch(ArrayIndexOutOfBoundsException e){
			System.out.println(e+"\nPlease give proper inputs next time!!");
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
}
		