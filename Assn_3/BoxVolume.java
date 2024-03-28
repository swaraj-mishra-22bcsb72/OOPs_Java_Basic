import java.util.*;

class Box{
	double length;
	double breadth;
	double height;
	
	Box(){
		length = 0.0;
		breadth = 0.0;
		height = 0.0;
	}
	Box(double length, double breadth, double height){
		this.length = length;
		this.breadth = breadth;
		this.height = height;
	}
	void displayBoxDimension(){
		System.out.println("Dimensions \nLength: "+length+"\nBreadth: "+breadth+"\nHeight: "+height);
	}
	double getVolume(){
		return length*breadth*height;
	}
}

//Driver class
class BoxVolume{
	public static void main(String []args){
		Box ob1 = new Box(10.0, 12.0, 15.0);
		ob1.displayBoxDimension();
		System.out.println("Volume of the Box is: "+ob1.getVolume());
	}
}