package firstPackage;
public class Calculator{
	double data1;
	double data2;
	
	public Calculator(){
		data1 = 0.0;
		data2 = 0.0;
		System.out.println("Object created with default values onlu");
	}
	public Calculator(double d1, double d2){
		data1 = d1;
		data2 = d2;
	}
	
	public void getSum(){
		System.out.println("Sum of the given numbers is: " +(data1 + data2));		
	}
	public void getDifference(){
		System.out.println("Difference of the given numbers is: " +(data1 - data2));
	}
	public void getProduct(){
		System.out.println("Productof the given numbers is: " +(data1 * data2));
	}
	public void getQuotient(){
		System.out.println("Quotient of the given numbers is: " +Math.floor(data1 / data2));
	}
	public void getRemainder(){
		System.out.println("Quotient of the given numbers is: " +(data1 % data2));
	}
}