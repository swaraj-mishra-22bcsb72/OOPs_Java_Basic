import java.util.Scanner;
class LeapYear{
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
		System.out.print("Give input year: ");
		int year = sc.nextInt();
		if (year%100 == 0)
			if (year%4 == 0)
				System.out.println(year+" is a leap year");
			else
				System.out.println(year+" is not a leap year");
		else if (year%4 == 0)
			System.out.println(year+" is a leap year");
    }
}