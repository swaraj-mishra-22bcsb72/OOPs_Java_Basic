import java.util.Scanner;

interface ScientificCalculator extends Calculator {
    void square(double a);
    void squareRoot(double a);
    void cube(double a);
}

class ConCalculator implements ScientificCalculator {
  
    public void addNumber(double a, double b) {
        System.out.println("Addition: " + (a + b));
    }

    public void subNumber(double a, double b) {
        System.out.println("Subtraction: " + (a - b));
    }

    public void mulNumber(double a, double b) {
        System.out.println("Multiplication: " + (a * b));
    }

    public void divNumber(double a, double b) {
        if (b != 0) {
            System.out.println("Division: " + (a / b));
        } else {
            System.out.println("Cannot divide by zero.");
        }
    }

    public void square(double a) {
        System.out.println("Square: " + (a * a));
    }

    public void squareRoot(double a) {
        if (a >= 0) {
            System.out.println("Square Root: " + Math.sqrt(a));
        } else {
            System.out.println("Invalid input for square root.");
        }
    }

    public void cube(double a) {
        System.out.println("Cube: " + (a * a * a));
    }
}



class CalculatorDriver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ScientificCalculator scientificCalculator = new ConCalculator();
        Calculator calculator = new ConCalculator();

        System.out.print("Enter first number: ");
        double num1 = scanner.nextDouble();
        System.out.print("Enter second number: ");
        double num2 = scanner.nextDouble();
                  
        System.out.println("\nUsing ScientificCalculator Interface:");
        scientificCalculator.addNumber(num1, num2);
        scientificCalculator.subNumber(num1, num2);
        scientificCalculator.mulNumber(num1, num2);
        scientificCalculator.divNumber(num1, num2);
        scientificCalculator.square(num1);
        scientificCalculator.squareRoot(num1);
        scientificCalculator.cube(num1);

        System.out.println("\nUsing Calculator Interface:");
        calculator.addNumber(num1, num2);
        calculator.subNumber(num1, num2);
        calculator.mulNumber(num1, num2);
        calculator.divNumber(num1, num2);

        scanner.close();
    }
}

