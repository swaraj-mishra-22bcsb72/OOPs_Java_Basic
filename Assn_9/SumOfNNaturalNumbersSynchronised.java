import java.util.Scanner;

class SumCalculator implements Runnable {
    private static int sum = 0;
    private static int n;
    private int start;

    public SumCalculator(int start) {
        this.start = start;
    }

    public static synchronized void addToSum(int num) {
        sum += num;
    }

    public void run() {
        int localSum = 0;
        for (int i = start; i <= n; i += Main.numOfThreads) {
            localSum += i;
        }
        addToSum(localSum);
    }

    public static int getSum() {
        return sum;
    }

    public static void setN(int num) {
        n = num;
    }
}

class Main {
    public static int numOfThreads = 0;
    public static int n = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of threads: ");
        numOfThreads = scanner.nextInt();

        System.out.print("Enter the value of n (natural numbers range): ");
        n = scanner.nextInt();

        SumCalculator.setN(n);
        Thread[] threads = new Thread[numOfThreads];

        for (int i = 0; i < numOfThreads; i++) {
            threads[i] = new Thread(new SumCalculator(i + 1));
            threads[i].start();
        }
		
        for (int i = 0; i < numOfThreads; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
			}
		}
        System.out.println("Sum of first " + n + " natural numbers using " + numOfThreads + " threads: " + SumCalculator.getSum());

        scanner.close();
    }
}
