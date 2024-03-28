import java.util.Scanner;
class Factors{
    public static void main(String []args){
        int ll = 0, ul, N;

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter value for N: ");
        N = sc.nextInt();
		for(int i = 1; i <= N; i++){
			if(N%i == 0){
				System.out.print(i+" ");
			}
		}
		System.out.println();
	}
}