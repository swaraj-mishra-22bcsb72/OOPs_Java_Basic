import java.util.Scanner;

class ThreadCountMismatch extends Exception {
    ThreadCountMismatch(String s) {
        super(s);
    }
}

class MyThread extends Thread {
    int lowerBound;
    int upperBound;
    int[] vec1;
    int[] vec2;
    int localSum = 0;

    MyThread(int[] vec1, int[] vec2, int lowerBound, int upperBound) {
        this.vec1 = vec1;
        this.vec2 = vec2;
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }

    public void run() {
        for (int i = lowerBound; i <= upperBound; i++) {
            localSum += vec1[i] * vec2[i];
        }
    }

    public int getLocalSum() {
        return localSum;
    }
}

public class MultiThreadAndVectors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of vectors: ");
        int size = scanner.nextInt();
        
        int[] vec1 = new int[size];
        int[] vec2 = new int[size];

        System.out.println("Enter elements of vector 1:");
        for (int i = 0; i < size; i++) {
            vec1[i] = scanner.nextInt();
        }

        System.out.println("Enter elements of vector 2:");
        for (int i = 0; i < size; i++) {
            vec2[i] = scanner.nextInt();
        }

        int threadCount = Runtime.getRuntime().availableProcessors();

        int elementsPerThread = size / threadCount;
        int remainingElements = size % threadCount;

        MyThread[] threads = new MyThread[threadCount];
        int lowerBound = 0;
        int upperBound = elementsPerThread - 1;

        for (int i = 0; i < threadCount; i++) {
            if (i == threadCount - 1) {
                upperBound += remainingElements; // Assign remaining elements to the last thread
            }

            threads[i] = new MyThread(vec1, vec2, lowerBound, upperBound);
            threads[i].start();

            lowerBound = upperBound + 1;
            upperBound += elementsPerThread;
        }

        int totalSum = 0;

        for (int i = 0; i < threadCount; i++) {
            try {
                threads[i].join();
                totalSum += threads[i].getLocalSum();
            } catch (InterruptedException e) {
                System.err.println("Thread interrupted");
            }
        }

        System.out.println("Scalar product = " + totalSum);

        scanner.close();
    }
}

 /*
 
import java.util.Scanner;

class DotProductThread extends Thread {
    private int[] vector1;
    private int[] vector2;
    private int startIndex;
    private int endIndex;
    private long partialDotProduct;

    public DotProductThread(int[] vector1, int[] vector2, int startIndex, int endIndex) {
        this.vector1 = vector1;
        this.vector2 = vector2;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        this.partialDotProduct = 0;
    }

    public long getPartialDotProduct() {
        return partialDotProduct;
    }

    public void run() {
        for (int i = startIndex; i < endIndex; i++) {
            partialDotProduct += vector1[i] * vector2[i];
        }
    }
}

public class MultiThreadAndVectors {
    public static long computeDotProduct(int[] vector1, int[] vector2, int numThreads) {
        int vectorSize = vector1.length;
        if (vectorSize != vector2.length) {
            throw new IllegalArgumentException("Vector sizes do not match");
		}
        if (vectorSize % numThreads != 0) {
            throw new IllegalArgumentException("Vector size is not a multiple of the number of threads");
        }

        DotProductThread[] threads = new DotProductThread[numThreads];
        int blockSize = vectorSize / numThreads;
        for (int i = 0; i < numThreads; i++) {
            int startIndex = i * blockSize;
            int endIndex = startIndex + blockSize;
            threads[i] = new DotProductThread(vector1, vector2, startIndex, endIndex);
            threads[i].start();
        }
        try {
            for (int i = 0; i < numThreads; i++) {
                threads[i].join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Calculate total dot product from partial results
        long totalDotProduct = 0;
        for (int i = 0; i < numThreads; i++) {
            totalDotProduct += threads[i].getPartialDotProduct();
        }

        return totalDotProduct;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of vectors: ");
        int size = scanner.nextInt();
        int[] vector1 = new int[size];
        int[] vector2 = new int[size];

        System.out.println("Enter elements of vector1:");
        for (int i = 0; i < size; i++) {
            System.out.print("Enter element " + (i + 1) + ": ");
            vector1[i] = scanner.nextInt();
        }

        System.out.println("Enter elements of vector2:");
        for (int i = 0; i < size; i++) {
            System.out.print("Enter element " + (i + 1) + ": ");
            vector2[i] = scanner.nextInt();
        }

        System.out.print("Enter the number of threads: ");
        int numThreads = scanner.nextInt();

        scanner.close();

        long dotProduct = computeDotProduct(vector1, vector2, numThreads);
        System.out.println("Dot Product: " + dotProduct);
    }
}
*/
