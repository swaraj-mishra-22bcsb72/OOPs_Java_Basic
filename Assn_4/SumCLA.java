class SumOfNumbers {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Please provide exactly two integers as command line arguments.");
            return;
        }

        try {
            int num1 = Integer.parseInt(args[0]);
            int num2 = Integer.parseInt(args[1]);

            int sum = num1 + num2;
            System.out.println("Sum of " + num1 + " and " + num2 + " is: " + sum);
        } catch (NumberFormatException e) {
            System.out.println("Please provide valid integers as command line arguments.");
        }
    }
}
