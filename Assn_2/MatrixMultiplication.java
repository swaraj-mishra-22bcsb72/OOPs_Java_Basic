import java.util.Scanner;
import java.util.Arrays;

class MatrixMul {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
		System.out.print("Enter the value for m1 and n1: ");
		int m1 = sc.nextInt();
		int n1 = sc.nextInt();
		
		System.out.print("Enter the value for m2 and n2: ");
		int m2 = sc.nextInt();
		int n2 = sc.nextInt();
		
		if (n1 == m2){
			int[] mat1[] = new int[m1][n1];
			int[] mat2[] = new int[m2][n2];
			int[] res[] = new int[m1][n2];
			System.out.println("Inputs for Matrix 1");
			for (int i = 0; i < m1; i++) {
				System.out.print("Give "+n1+" inputs for row "+i+" : ");
				for (int j = 0; j < n1; j++) {
					mat1[i][j] = sc.nextInt();
				}
			}
			System.out.println("Inputs for Matrix 2");
			for (int i = 0; i < m2; i++) {
				System.out.print("Give "+n2+" inputs for row "+i+" : ");
				for (int j = 0; j < n1; j++) {
					mat2[i][j] = sc.nextInt();
				}
			}
			for (int i = 0; i < m1; i++) {
				for (int j = 0; j < n2; j++) {
					res[i][j] = 0;
					for (int k = 0; k < m2; k++) {
						res[i][j]+=mat1[i][k]*mat2[k][j];
					}
				}
			}
			for (int i = 0; i < m1; i++) {
				for (int j = 0; j < n2; j++) {
					System.out.print(res[i][j]+"  ");
				}
				System.out.println();
			}
		}
		else {
			return;
		}
	}
}