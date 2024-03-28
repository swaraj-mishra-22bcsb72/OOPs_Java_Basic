import java.util.Scanner;

class MinimumFinder implements Runnable {
    private static int[] arr;
    private static int min = Integer.MAX_VALUE;
    private int startIndex, endIndex;

    public MinimumFinder(int startIndex, int endIndex) {
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    public static synchronized void updateMin(int newMin) {
        if (newMin < min) {
            min = newMin;
        }
    }

    public void run() {
        int localMin = Integer.MAX_VALUE;
        for (int i = startIndex; i < endIndex; i++) {
            if (arr[i] < localMin) {
                localMin = arr[i];
            }
        }
        updateMin(localMin);
    }

    public static int getMin() {
        return min;
    }

    public static void setArray(int[] inputArray) {
        arr = inputArray;
    }
}

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        int numOfElements = scanner.nextInt();

        System.out.print("Enter the number of threads: ");
        int numOfThreads = scanner.nextInt();

        int[] array = new int[numOfElements];
        for (int i = 0; i < numOfElements; i++) {
            System.out.print("Enter element " + (i + 1) + ": ");
            array[i] = scanner.nextInt();
        }

        MinimumFinder.setArray(array);
        Thread[] threads = new Thread[numOfThreads];

        int blockSize = numOfElements / numOfThreads;
        int startIndex = 0;
        int endIndex = blockSize;

        for (int i = 0; i < numOfThreads; i++) {
            if (i == numOfThreads - 1) {
                endIndex = numOfElements;
            }
            threads[i] = new Thread(new MinimumFinder(startIndex, endIndex));
            threads[i].start();
            startIndex = endIndex;
            endIndex = Math.min(endIndex + blockSize, numOfElements);
        }

        for (int i = 0; i < numOfThreads; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Minimum Element: " + MinimumFinder.getMin());

        scanner.close();
    }
}
