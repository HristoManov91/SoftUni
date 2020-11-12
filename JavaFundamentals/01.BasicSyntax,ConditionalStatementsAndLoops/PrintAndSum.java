import java.util.Scanner;

public class PrintAndSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int startIndex = Integer.parseInt(scanner.nextLine());
        int endIndex = Integer.parseInt(scanner.nextLine());

        int sumOfNumbers = 0;
        for (int i = startIndex; i <= endIndex ; i++) {
            sumOfNumbers += i;
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.printf("Sum: %d", sumOfNumbers);
    }
}
