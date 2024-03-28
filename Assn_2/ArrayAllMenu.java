import java.util.Scanner;

class ArrayMenuDriven {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = null;
        int size = 0;

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Insert Element");
            System.out.println("2. Display Array");
            System.out.println("3. Traverse Array");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    if (arr == null) {
                        System.out.print("Enter the size of the array: ");
                        size = sc.nextInt();
                        arr = new int[size];
                        System.out.println("Array of size " + size + " created.");
                    }
                    
                    System.out.print("Enter the index to insert the element: ");
                    int index = sc.nextInt();
                    
                    if (index >= 0 && index < size) {
                        System.out.print("Enter the element to insert: ");
                        int element = sc.nextInt();
                        arr[index] = element;
                        System.out.println("Element " + element + " inserted at index " + index);
                    } else {
                        System.out.println("Invalid index. Index must be between 0 and " + (size - 1));
                    }
                    break;

                case 2:
                    if (arr == null) {
                        System.out.println("Array does not exist. Please create the array first.");
                    } else {
                        System.out.println("Array elements:");
                        for (int i = 0; i < size; i++) {
                            System.out.print(arr[i] + " ");
                        }
                        System.out.println();
                    }
                    break;

                case 3:
                    if (arr == null) {
                        System.out.println("Array does not exist. Please create the array first.");
                    } else {
                        System.out.println("Traversing Array:");
                        for (int i = 0; i < size; i++) {
                            System.out.println("Element at index " + i + ": " + arr[i]);
                        }
                    }
                    break;

                case 4:
                    System.out.println("Exiting the program.");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }
}
