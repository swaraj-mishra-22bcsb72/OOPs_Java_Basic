import java.util.Scanner;
class exp{
    public static void main(String []args){
        double x, n;
		double e = 1.0, term = 1.0;

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter value of x and n: ");
		x = sc.nextDouble();
		n = sc.nextDouble();
		for (int i = 1; i < n; i++){
			term *= x/i;
			e += term;
		}
		System.out.println("e^"+x+" is "+e);
	}
}
			