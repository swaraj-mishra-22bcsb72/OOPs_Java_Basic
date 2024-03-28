import java.util.Scanner;
class EveO{
    public static void main(String []args){
        int num, i;

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a no.: ");
        num = sc.nextInt();

        if(num%2 == 0 && num != 0)
			System.out.println(num+ " is an even number");
		else
			System.out.println(num+ " is an odd number");

    }
}