import java.util.Scanner;

class Employee {
    String empName;
    int empNumber;
    double basicSal;
    double DA;
    double HRA;

    public Employee() {}

    public Employee(String empName, int empNumber, double basicSal, double DA, double HRA) {
        this.empName = empName;
        this.empNumber = empNumber;
        this.basicSal = basicSal;
        this.DA = DA;
        this.HRA = HRA;
    }

    public double calGrossSal() {
        return basicSal + DA + HRA;
    }

    public void showEmpDetails() {
        System.out.println("Employee Name: " + empName);
        System.out.println("Employee Number: " + empNumber);
        System.out.println("Basic Salary: " + basicSal);
        System.out.println("DA: " + DA);
        System.out.println("HRA: " + HRA);
        System.out.println("Gross Salary: " + calGrossSal());
        System.out.println();
    }
}

class EmployeeInfoSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Employee[] employees = new Employee[3];

        for (int i = 0; i < 3; i++) {
            System.out.println("Enter details for Employee " + (i + 1));
            System.out.print("Name: "); String empName = scanner.nextLine();
            System.out.print("Employee Number: "); int empNumber = scanner.nextInt();
            System.out.print("Basic Salary: "); double basicSal = scanner.nextDouble();
            System.out.print("DA: "); double DA = scanner.nextDouble();
            System.out.print("HRA: "); double HRA = scanner.nextDouble();

            employees[i] = new Employee(empName, empNumber, basicSal, DA, HRA);
            scanner.nextLine();
        }

        System.out.println("Employees with Gross Salary > 50,000:");
        for (Employee employee : employees) {
            if (employee.calGrossSal() > 50000) {
                employee.showEmpDetails();
            }
        }

        scanner.close();
    }
}
