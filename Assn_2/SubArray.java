import java.util.Scanner;

/*
class SubarrayWithZeroSum {
    public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter the size of the array: ");
		int n = scanner.nextInt();
		
		int[] arr = new int[n];
		System.out.println("Enter the elements of the array:");
		for (int i = 0; i < n; i++) {
			arr[i] = scanner.nextInt();
		}

		boolean foundZeroSumSubarray = false;

		for (int i = 0; i < n; i++) {
			int sum = 0;

			for (int j = i; j < n; j++) {
				sum += arr[j];

				if (sum == 0) {
					foundZeroSumSubarray = true;
					break;
				}
			}
			
			if (foundZeroSumSubarray) {
				break;
			}
		}
		
		System.out.println("Does the array have a subarray with a sum of 0? " + foundZeroSumSubarray);
    }
}
*/
class Subset{
	void checkSubsetSumAndPrint(int set[], int sumLimit){
		int n = set.length;
		for (int i = 0; i < (1<<n); i++){
			int sum = 0;
			int k = 0; 
			String sub = "";
			for (int j = 0; j < n; j++){
				if((i & (1<<j)) > 0){
					sum += set[j];
					sub += set[j];
					sub += " ";
				}
			}
			if(sum == sumLimit){
				System.out.println(sub);
			}			
		}
	}
}
class Driver{
	public static void main(String []args){
		Scanner sc = new Scanner(System.in);
		int[] set = new int[3];
		System.out.println("Enter array of 3 numbers: ");
		for(int i=0;i<3;i++){
			set[i]=sc.nextInt();
		}		
		int n = 0;
		Subset ob = new Subset();
		ob.checkSubsetSumAndPrint(set, n);
	}
}