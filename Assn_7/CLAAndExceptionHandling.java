import java.util.Scanner;

class WrongCredential extends Exception{
	WrongCredential(String s){
		super(s);
	}
}
class CLAAndExceptionHandling{
	public static void main(String[] args){
		
		try{
			if(args.length == 1){
				throw new ArrayIndexOutOfBoundsException("Less number of inputs were given than requirement");
			}
			if (args.length == 0){
				throw new ArithmeticException("No arguments passed to a CLA based program");
			}
			else{
				String username = args[0];
				String password = args[1];
				if(username != password){
					throw new WrongCredential("Mismatch in username and password");
				}
			}
		}
		catch(ArrayIndexOutOfBoundsException e){
			System.out.println(e);
		}
		
		catch(ArithmeticException e){
			System.out.println(e);
		}
		
		catch(WrongCredential e){
			System.out.println(e);
		}
	}
}
			