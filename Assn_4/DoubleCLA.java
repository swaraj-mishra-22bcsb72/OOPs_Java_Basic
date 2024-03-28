class SumOfDoubles {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Please provide at least one double value as a command line argument.");
            return;
        }

        double sum = 0.0;
        try {
            for (String arg : args) {
                double num = Double.parseDouble(arg);
                sum += num;
            }
            System.out.println("Sum of the numbers is: " + sum);
        } catch (NumberFormatException e) {
            System.out.println("Please provide valid double values as command line arguments.");
        }
    }
}
