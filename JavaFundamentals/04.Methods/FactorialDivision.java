import java.util.Scanner;

public class FactorialDivision {

    static double factorial(long number) {
        if (number == 0) {
            return 1;
        } else {
            return (number * factorial(number - 1));
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long number1 = Integer.parseInt(scanner.nextLine());
        long number2 = Integer.parseInt(scanner.nextLine());

        double result = factorial(number1) / factorial(number2);
        System.out.printf("%.2f", result);
    }
}
