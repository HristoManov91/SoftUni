import java.util.Scanner;

public class FromLeftToRight {

    private static Integer sumOfDigit(double number1) {
        int sumOfDigit = 0;
        while (number1 > 0) {
            double currentDigit = number1 % 10;
            sumOfDigit += currentDigit;
            number1 /= 10;
        }
        return sumOfDigit;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < count; i++) {
            String[] numbers = scanner.nextLine().split(" ");
            double number1 = Double.parseDouble(numbers[0]);
            double number2 = Double.parseDouble(numbers[1]);
            if (number1 > number2) {
                Math.abs(number1);
                System.out.println(sumOfDigit(number1));
            } else {
                Math.abs(number2);
                System.out.println(sumOfDigit(number2));
            }
        }
    }
}
