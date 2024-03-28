//Define a class point which can be used to create 2D Coordinate, create 3 objects of this class and check if they are co-linear or not;

import java.util.*;

class Point{
	double x;
	double y;
	Point(){
		x = 0.0;
		y = 0.0;
	}
	Point(double x, double y){
		this.x = x;
		this.y = y;
	}
	void displayPoint(){
		System.out.println("Coordinate \nx: "+x+"\ny: "+y);
	}
	boolean collinearity(Point ob1, Point ob2){
		if(((ob1.y-y)/(ob1.x-x)) == ((ob2.y-y)/(ob2.x-x))){
			return true;
		}
		else{
			return false;
		}
	}
}

//Driver class
class Colinear{
	public static void main(String []args){
		Point ob1 = new Point(10.0, 12.0);
		ob1.displayPoint();
		Point ob2 = new Point(11.0, 13.0);
		ob2.displayPoint();
		Point ob3 = new Point(5.0, 7.0);
		ob3.displayPoint();
		if (ob1.collinearity(ob1, ob2)){
			System.out.println("Points are Co-Linear");
		}
		else{
			System.out.println("Points are not Co-Linear");
		}
	}
}
	