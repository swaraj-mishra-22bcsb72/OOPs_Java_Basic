import java.util.Scanner;
import java.util.Arrays;

class ArrayLinearOrBinarySearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements in the array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        Arrays.sort(arr);

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Linear Search");
            System.out.println("2. Binary Search");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            if (choice == 1) {
                System.out.print("Enter the element to search: ");
                int target = sc.nextInt();
                int index = -1;

                for (int i = 0; i < n; i++) {
                    if (arr[i] == target) {
                        index = i;
                        break;
                    }
                }

                if (index != -1) {
                    System.out.println("Element " + target + " found at index " + index);
                } else {
                    System.out.println("Element " + target + " not found in the array.");
                }
            } else if (choice == 2) {
                System.out.print("Enter the element to search: ");
                int target = sc.nextInt();
                int index = Arrays.binarySearch(arr, target);

                if (index >= 0) {
                    System.out.println("Element " + target + " found at index " + index);
                } else {
                    System.out.println("Element " + target + " not found in the array.");
                }
            } else if (choice == 3) {
                break;
            } else {
                System.out.println("Invalid choice. Please select a valid option.");
            }
        }

        sc.close();
    }
}
