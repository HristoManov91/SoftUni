import java.util.ArrayDeque;
import java.util.Scanner;

public class DecimalToBinary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int decimalNumber = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> binaryRepresentation = new ArrayDeque<>();

        if (decimalNumber == 0) {
            System.out.println(0);
        } else {
            while (decimalNumber != 0) {
                binaryRepresentation.push(decimalNumber % 2);
                decimalNumber /= 2;
            }
            while (!binaryRepresentation.isEmpty()) {
                System.out.print(binaryRepresentation.pop());
            }
        }
    }
}
