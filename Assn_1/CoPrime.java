import java.util.Scanner;
class CoPrimeRange{
    public static void main(String []args){
        int ll = 0, ul, N;

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter value for N: ");
        N = sc.nextInt();
		
		ul = N;
		System.out.println("Co-Prime Number range is ");
		for(int i = ll; i <= ul; i++){
			int a = N;int b = i;
			int rem, gcd;
			while(b != 0){
				rem = a%b;
				a = b;
				b = rem;
			}
			gcd = a;
			if(gcd == 1 && i*N == N){
				System.out.println(i+" ");
			}
		}
		System.out.println();
	}
}
			