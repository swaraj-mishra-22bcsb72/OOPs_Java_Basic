package firstPackage;
public class Demo{
	public void display(int a){
		System.out.println("Value is: " +a);
	}
	public void func1(){
		System.out.println("I am inside public func1 of Demo class of first package");
	}
	/*
	private void func2(){
		System.out.println("I am inside private func2 of Demo class of first package");
	}
	void func3(){
		System.out.println("I am inside private func2 of Demo class of first package");
	}
	*/
	protected void func4(){
		System.out.println("I am inside protected func3 of Demo class of first package");
	}
}
