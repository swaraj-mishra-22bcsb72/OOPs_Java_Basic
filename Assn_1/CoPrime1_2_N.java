import java.util.Scanner;
class CoPrimeRange{
    public static void main(String []args){
        int N;

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter value for N: ");
        N = sc.nextInt();
		
		System.out.println("Co-Prime Number range is ");
		for(int i = 2; i <= N; i++){
			int a = N;
			int b = i;
			int rem, gcd;
			while(b != 0){
				rem = a%b;
				a = b;
				b = rem;
			}
			gcd = a;
			if(gcd == 1){
				System.out.println(i+" and "+ N+" are Co-Prime");
			}
		}
		System.out.println();
	}
}			