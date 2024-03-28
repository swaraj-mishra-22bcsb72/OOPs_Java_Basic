import java.util.Scanner;

class MatrixMultiplier extends Thread {
    private final int[][] matrix1;
    private final int[][] matrix2;
    private final int[][] result;
    private final int startRow;
    private final int endRow;

    public MatrixMultiplier(int[][] matrix1, int[][] matrix2, int[][] result, int startRow, int endRow) {
        this.matrix1 = matrix1;
        this.matrix2 = matrix2;
        this.result = result;
        this.startRow = startRow;
        this.endRow = endRow;
    }

    public void run() {
        for (int i = startRow; i < endRow; i++) {
            for (int j = 0; j < matrix2[0].length; j++) {
                for (int k = 0; k < matrix1[0].length; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
    }
}

class MatrixMultiplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of rows for the first matrix: ");
        int rows1 = scanner.nextInt();
        System.out.print("Enter the number of columns for the first matrix: ");
        int cols1 = scanner.nextInt();

        System.out.print("Enter the number of rows for the second matrix: ");
        int rows2 = scanner.nextInt();
        System.out.print("Enter the number of columns for the second matrix: ");
        int cols2 = scanner.nextInt();

        if (cols1 != rows2) {
            System.out.println("Matrix multiplication is not possible. The number of columns in the first matrix must be equal to the number of rows in the second matrix.");
            return;
        }

        System.out.print("Enter the number of threads: ");
        int numThreads = scanner.nextInt();

        int[][] matrix1 = new int[rows1][cols1];
        int[][] matrix2 = new int[rows2][cols2];
        int[][] result = new int[rows1][cols2];

        System.out.println("Enter elements for the first matrix:");
        inputMatrix(matrix1, scanner);

        System.out.println("Enter elements for the second matrix:");
        inputMatrix(matrix2, scanner);

        long startTime = System.currentTimeMillis();

        MatrixMultiplier[] threads = new MatrixMultiplier[numThreads];
        int rowsPerThread = rows1 / numThreads;
        int startRow = 0;

        for (int i = 0; i < numThreads; i++) {
            int endRow = i == numThreads - 1 ? rows1 : startRow + rowsPerThread;
            threads[i] = new MatrixMultiplier(matrix1, matrix2, result, startRow, endRow);
            threads[i].start();
            startRow = endRow;
        }

        try {
            for (MatrixMultiplier thread : threads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;

        System.out.println("\nResultant Matrix after multiplication:");
        printMatrix(result);

        System.out.println("\nTime taken for matrix multiplication: " + totalTime + " milliseconds");
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
