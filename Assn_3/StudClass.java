import java.util.Scanner;

class Student {
    String name;
    int roll;
    int[] marks = new int[5];
    String branch;
    String collegeName;

    public Student() {
		name = null;
		roll = 0;
		branch = null;
		collegeName = null;
	}

    public Student(String name, int roll, int[] marks, String branch, String collegeName) {
        this.name = name;
        this.roll = roll;
        this.marks = marks;
        this.branch = branch;
        this.collegeName = collegeName;
    }

    public void displayDetails() {
        System.out.println("Name: " + name + ", Roll: " + roll + ", Marks: " + marksStr() +
                ", Branch: " + branch + ", College: " + collegeName);
    }

    public double calculateAverage() {
        int sum = 0;
        for (int mark : marks) sum += mark;
        return (double) sum / marks.length;
    }

    private String marksStr() {
        StringBuilder result = new StringBuilder();
        for (int mark : marks) result.append(mark).append(" ");
        return result.toString().trim();
    }
}

class StudentInfoSystem {
    public static void main(String[] args) {
		int n = 2;
        Scanner scanner = new Scanner(System.in);
        Student[] students = new Student[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter details for Student " + (i + 1));
            System.out.print("Name: "); String name = scanner.nextLine();
            System.out.print("Roll Number: "); int roll = scanner.nextInt();
            System.out.print("Enter 5 subject marks: "); int[] marks = new int[5];
            for (int j = 0; j < 5; j++) marks[j] = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Branch: "); String branch = scanner.nextLine();
            System.out.print("College Name: "); String collegeName = scanner.nextLine();

            students[i] = new Student(name, roll, marks, branch, collegeName);
        }

        double highestAverage = 0;
        int highestAverageIndex = 0;

        for (int i = 0; i < n; i++) {
            double average = students[i].calculateAverage();
            if (average > highestAverage) {
                highestAverage = average;
                highestAverageIndex = i;
            }
        }

        System.out.println("\nDetails of the student with the highest average marks:");
        students[highestAverageIndex].displayDetails();

        scanner.close();
    }
}
