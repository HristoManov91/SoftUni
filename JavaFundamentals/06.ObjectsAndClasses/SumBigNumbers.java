import java.math.BigInteger;
import java.util.Scanner;

public class SumBigNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigInteger firstBigInteger = new BigInteger(scanner.nextLine());
        BigInteger secondBigInteger = new BigInteger(scanner.nextLine());

        BigInteger result = firstBigInteger.add(secondBigInteger);

        System.out.println(result);
    }
}
