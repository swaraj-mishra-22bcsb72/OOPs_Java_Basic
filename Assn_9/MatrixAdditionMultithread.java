import java.util.Scanner;

class MatrixAdder extends Thread {
    private final int[][] matrix1;
    private final int[][] matrix2;
    private final int[][] result;
    private final int startRow;
    private final int endRow;

    public MatrixAdder(int[][] matrix1, int[][] matrix2, int[][] result, int startRow, int endRow) {
        this.matrix1 = matrix1;
        this.matrix2 = matrix2;
        this.result = result;
        this.startRow = startRow;
        this.endRow = endRow;
    }

    @Override
    public void run() {
        for (int i = startRow; i < endRow; i++) {
            for (int j = 0; j < matrix1[0].length; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
    }
}

public class MatrixAddition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of rows for the matrices: ");
        int rows = scanner.nextInt();
        System.out.print("Enter the number of columns for the matrices: ");
        int cols = scanner.nextInt();

        int[][] matrix1 = new int[rows][cols];
        int[][] matrix2 = new int[rows][cols];
        int[][] result = new int[rows][cols];

        System.out.println("Enter elements for the first matrix:");
        inputMatrix(matrix1, scanner);

        System.out.println("Enter elements for the second matrix:");
        inputMatrix(matrix2, scanner);

        System.out.print("Enter the number of threads: ");
        int numThreads = scanner.nextInt();

        long startTime = System.currentTimeMillis();

        MatrixAdder[] threads = new MatrixAdder[numThreads];
        int rowsPerThread = rows / numThreads;
        int startRow = 0;

        for (int i = 0; i < numThreads; i++) {
            int endRow = i == numThreads - 1 ? rows : startRow + rowsPerThread;
            threads[i] = new MatrixAdder(matrix1, matrix2, result, startRow, endRow);
            threads[i].start();
            startRow = endRow;
        }

        try {
            for (MatrixAdder thread : threads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;

        System.out.println("\nResultant Matrix after addition:");
        printMatrix(result);

        System.out.println("\nTime taken for matrix addition: " + totalTime + " milliseconds");
    }

    private static void inputMatrix(int[][] matrix, Scanner scanner) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print("Enter element at position (" + (i + 1) + "," + (j + 1) + "): ");
                matrix[i][j] = scanner.nextInt();
            }
        }
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}
