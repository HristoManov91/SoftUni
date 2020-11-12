import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int multiplier = Integer.parseInt(scanner.nextLine());
        int startNumber = Integer.parseInt(scanner.nextLine());

        if (startNumber <= 10) {
            for (int i = startNumber; i <= 10; i++) {
                System.out.printf("%d X %d = %d%n", multiplier, i, multiplier * i);
            }
        } else {
            System.out.printf("%d X %d = %d", multiplier , startNumber , multiplier * startNumber);
        }
    }
}
