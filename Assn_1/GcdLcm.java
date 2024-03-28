import java.util.Scanner;
class GcdLcm{
    public static void main(String []args){
        int num1, num2;
		int gcd = 1, rem;
		int count = 0;

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a no.: ");
        num1 = sc.nextInt();
		num2 = sc.nextInt();
		
		/*
		Basic Logic with higher time complexity
		*/
		/*
		int min = (num1 <= num2)? num1: num2;

        for (int i = 2; i <= min; i++){
			if (num1%i == 0  && num2%i == 0)
				gcd = i;
        }
		*/
		
		/*
		Efficient logic
		*/
		int a = num1, b = num2;
		while(b != 0){
			count++;
			rem = a%b;
			a = b;
			b = rem;
		}
		gcd = a;
		
		System.out.println(gcd+" is the GCD of "+num1+" & "+num2+" and it's LCM is "+(num1*num2/gcd)+"\nIt took "+count+" no. of iterations");
		
	}
}