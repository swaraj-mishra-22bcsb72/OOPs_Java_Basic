import java.util.Scanner;
import java.util.Arrays;

class VectorsScalarProd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int[] vec1 = new int[3];
		int[] vec2 = new int[3];
		
		System.out.print("Enter the value for x1, y1 and z1: ");
		for (int i = 0; i < 3; i++) {
            vec1[i] = sc.nextInt();
        }
				
		System.out.print("Enter the value for x2, y2 and z2: ");	
		for (int i = 0; i < 3; i++) {
            vec2[i] = sc.nextInt();
        }
		
		System.out.println("The scalar product is "+ ((vec1[0]*vec2[0]) +(vec1[1]*vec2[1])+(vec1[2]*vec2[2])));
	}
}