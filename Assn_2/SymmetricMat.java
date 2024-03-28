import java.util.Scanner;
import java.util.Arrays;

class SymmCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
		System.out.print("Enter the value for m and n: ");
		int m = sc.nextInt();
		int n = sc.nextInt();

		int[] mat[] = new int[m][n];
		System.out.println("Inputs for Matrix");
		for (int i = 0; i < m; i++) {
			System.out.print("Give "+n+" inputs for row "+i+" : ");
			for (int j = 0; j < n; j++) {
				mat[i][j] = sc.nextInt();
			}
		}
		int i = 0, j = 0;
		for ( i = 0; i < m; i++) {
			for ( j = 0; j < n; j++) {
				if (mat[i][j] != mat[j][i]){
					break;
				}
			}
		}
		if (i >= m && j >= n) {
			System.out.println("Matrix is Symmetric");
		}
		else {
			System.out.println("Not Symmetric");
		}
	}
}
		