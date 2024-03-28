class Stack {
    private int[] arr;
    private int top;

    public Stack() {
        arr = new int[10];
        top = -1;
    }

    public void push(int data) {
        if (top == arr.length - 1) {
            System.out.println("Stack Overflow");
            return;
        }
        arr[++top] = data;
    }

    public int pop() {
        if (top == -1) {
            System.out.println("Stack Underflow");
            return -1;
        }
        return arr[top--];
    }

    public int peek() {
        if (top == -1) {
            System.out.println("Stack Underflow");
            return -1;
        }
        return arr[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void display() {
        if (top == -1) {
            System.out.println("Stack is empty");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

class Driver {
    public static void main(String[] args) {
        Stack stack = new Stack();

        int choice;
        do {
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = Integer.parseInt(System.console().readLine());

            switch (choice) {
                case 1:
                    System.out.print("Enter data to push: ");
                    int data = Integer.parseInt(System.console().readLine());
                    stack.push(data);
                    break;
                case 2:
                    int poppedData = stack.pop();
                    if (poppedData != -1) {
                        System.out.println("Popped data: " + poppedData);
                    }
                    break;
                case 3:
                    int peekedData = stack.peek();
                    if (peekedData != -1) {
                        System.out.println("Peeked data: " + peekedData);
                    }
                    break;
                case 4:
                    stack.display();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        } while (choice != 5);
    }
}

