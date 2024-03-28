import firstPackage.Demo;
import firstPackage.Calculator;

public class firstPackage{
	public static void main(String[] args){
		Demo Demon = new Demo();
		Demon.display(19);
		Calculator Calci = new Calculator(10, 11);
		Calci.getSum();
		Calci.getProduct();
		Calci.getDifference();
		Calci.getQuotient();
		Calci.getRemainder();
		DemonDriver Object = new DemonDriver();
		Object.fun();
	}
}
class AdvanceCalculator extends Calculator{
	void fun(){
		func1();
		//func2();
		//func3();
		func4();
	}
}