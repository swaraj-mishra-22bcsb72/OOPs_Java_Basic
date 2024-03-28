import java.util.Scanner;
class PrimeC{
    public static void main(String []args){
        int num, i;

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a no.: ");
        num = sc.nextInt();

        if (num <= 0 || num == 2){
            System.out.println(num+" is a Prime number");
        }

        for(i = 2; i <= Math.sqrt(num); i++){
            if (num%i == 0){
                System.out.println(num+" is a Composite number");
                break;
            }
        }
        if (i > Math.sqrt(num)){
            System.out.println(num+" is a Prime number");
        }

    }
}