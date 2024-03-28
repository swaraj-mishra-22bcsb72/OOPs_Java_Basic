import java.util.*;

class EvenThread extends Thread {
    private int start;
    private int end;

    public EvenThread(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public void run() {
        System.out.println("Even numbers between " + start + " and " + end + ":");
        for (int i = start; i <= end; i++) {
            if (i % 2 == 0) {
                System.out.print(i+ " ");
            }
        }
		System.out.println();
    }
}

public class OddNumbersMain {
    public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter start and end values: ");
        int m = scanner.nextInt(); 
        int n = scanner.nextInt(); 

        EvenThread evenThread = new EvenThread(m, n);
        evenThread.start();

        System.out.println("Odd numbers between " + m + " and " + n + ":");
        for (int i = m; i <= n; i++) {
            if (i % 2 != 0) {
                System.out.print(i+ " ");
            }
        }
		System.out.println();
    }
}
