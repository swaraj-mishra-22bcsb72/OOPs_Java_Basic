import java.util.*;

class ComplexNum{
	double real;
	double img;
	ComplexNum(){
		real = 0.0;
		img = 0.0;
	}
	ComplexNum(double real, double img){
		this.real = real;
		this.img = img;
	}
	void displayComplexNum(){
		System.out.println("Complex Number \nReal Part: "+real+"\nImaginary Part: "+img);
	}
	void addComplexNum(ComplexNum v1, ComplexNum v2){
		real = v1.real + v2.real;
		img = v1.img + v2.img;
	}
	void subComplexNum(ComplexNum v1, ComplexNum v2){
		real = v1.real - v2.real;
		img = v1.img - v2.img;
	}
	void mulComplexNum(ComplexNum v1, ComplexNum v2){
		real = v1.real*v2.real - v1.img*v2.img;
		img = v1.real*v2.img + v1.img*v2.real;
	}
	void divComplexNum(ComplexNum v1, ComplexNum v2){
		double dn = Math.pow(v2.real, 2)+Math.pow(v2.img, 2);
		real = (v1.real*v2.real + v2.img*v1.img)/dn;
		img = (v1.img*v2.real - v2.img*v1.real)/dn;
	}
}

//Driver class
class ComplexMenu{
	/*
	do{
		System.out.println("1. add\n2. sub\n3. mul\n4. div\n5. display\nEnter: ");
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		switch(choice){
			case 1:
	*/
	public static void main(String []args){
		ComplexNum ob1 = new ComplexNum(5.0, 4.0);
		ob1.displayComplexNum();
		ComplexNum ob2 = new ComplexNum(7.0, 3.0);
		ob1.displayComplexNum();
		ComplexNum ob = new ComplexNum();
		ob.displayComplexNum();
		
		System.out.println("1. add\n2. sub\n3. mul\n4. div\nEnter: ");
	
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
	
		
	
		if (choice == 1){
			ob.addComplexNum(ob1, ob2);
			ob.displayComplexNum();
		}
		else if (choice == 2){
			ob.subComplexNum(ob1, ob2);
			ob.displayComplexNum();
		}
		else if (choice == 3){
			ob.mulComplexNum(ob1, ob2);
			ob.displayComplexNum();
		}
		else if (choice == 4){
			ob.divComplexNum(ob1, ob2);
			ob.displayComplexNum();
		}
		else{
			System.out.println("Invalid Choice !!!");
		}
		
	}
}