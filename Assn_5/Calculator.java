import java.util.Scanner;

interface Calculator {
    void addNumber(double a, double b);
    void subNumber(double a, double b);
    void mulNumber(double a, double b);
    void divNumber(double a, double b);
}

class ConCalculator implements Calculator {
 
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
}

class CalculatorDriver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new ConCalculator();

        System.out.print("Enter first number: ");
        double num1 = scanner.nextDouble();
        System.out.print("Enter second number: ");
        double num2 = scanner.nextDouble();

        calculator.addNumber(num1, num2);
        calculator.subNumber(num1, num2);
        calculator.mulNumber(num1, num2);
        calculator.divNumber(num1, num2);

        scanner.close();
    }
}
