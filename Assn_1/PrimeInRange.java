import java.util.Scanner;
class PrimeRange{
    public static void main(String []args){
        int ll, ul;

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter values for lower and upper limit: ");
        ll = sc.nextInt();
		ul = sc.nextInt();
		
		System.out.println("Prime Number range is ");
		for(int i = ll; i <= ul; i++){
			int j = 2;
			for(; j <= Math.sqrt(i); j++){
				if(i%j == 0){
					break;
				}
			}
			if(j > Math.sqrt(i)){
				System.out.print(i+" ");
			}
		}
		System.out.println();
	}
}
			