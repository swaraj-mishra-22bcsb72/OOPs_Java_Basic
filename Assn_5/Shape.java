import java.util.Scanner;

abstract class Shape {
    double dimOne;
    double dimTwo;

    Shape(double dimOne, double dimTwo) {
        this.dimOne = dimOne;
        this.dimTwo = dimTwo;
    }

    abstract double computeArea();
}

class Rectangle extends Shape {
    Rectangle(double dimOne, double dimTwo) {
        super(dimOne, dimTwo);
    }

    double computeArea() {
        return dimOne * dimTwo;
    }
}

class Triangle extends Shape {
    Triangle(double dimOne, double dimTwo) {
        super(dimOne, dimTwo);
    }

    double computeArea() {
        return 0.5 * dimOne * dimTwo;
    }
}

class ShapeDriver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter length for Rectangle: ");
        double length = scanner.nextDouble();
        System.out.print("Enter breadth for Rectangle: ");
        double breadth = scanner.nextDouble();

        Shape rectangle = new Rectangle(length, breadth);

        System.out.print("Enter base for Triangle: ");
        double base = scanner.nextDouble();
        System.out.print("Enter height for Triangle: ");
        double height = scanner.nextDouble();

        Shape triangle = new Triangle(base, height);

        System.out.println("Area of Rectangle: " + rectangle.computeArea());
        System.out.println("Area of Triangle: " + triangle.computeArea());

        scanner.close();
    }
}
