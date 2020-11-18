import java.util.Scanner;

public class PrintNumbersInReverseOrder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countNumber = Integer.parseInt(scanner.nextLine());

        String[] numbers = new String[countNumber];
        for (int i = 0; i < countNumber; i++) {
            String num = scanner.nextLine();
            numbers[i] = num;
        }
        for (int i = numbers.length - 1; i >= 0 ; i--) {
            System.out.print(numbers[i] + " ");
        }
    }
}
