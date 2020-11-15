import java.util.Scanner;

public class SumOfChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());
        int sumOfChars = 0;
        for (int i = 0; i < count; i++) {
            char character = scanner.nextLine().charAt(0);
            int digit;
            digit = character;
            sumOfChars += digit;
        }
        System.out.printf("The sum equals: %d", sumOfChars);;
    }
}
