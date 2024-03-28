/*sin(X) =  X – X^3/3! + X^5/5! - …………………..*/

import java.util.Scanner;
class Srs{
    public static void main(String []args){
        double x, n;
		double sin, term;

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter value of x in degree and n: ");
		x = sc.nextDouble();
		n = sc.nextDouble();
		
		x = x*(3.142/180);
		term = sin = x;
		
		for (int i = 3; i < n; i += 2){
			term *= (-1*x*x)/(i*(i-1));
			sin += term;
		}
		System.out.println("sin("+x+") is "+sin);
	}
}
			