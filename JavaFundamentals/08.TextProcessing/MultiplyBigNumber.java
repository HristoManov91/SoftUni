import java.math.BigInteger;
import java.util.Scanner;

public class MultiplyBigNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String bigInteger = scanner.nextLine();
        while (bigInteger.charAt(0) == '0'){
            bigInteger = bigInteger.substring(1);
        }
        int multiplier = Integer.parseInt(scanner.nextLine());
        if (multiplier == 0){
            System.out.println(0);
            return;
        }

        StringBuilder sb = new StringBuilder();
        int reminder = 0;
        for (int i = bigInteger.length() - 1; i >= 0; i--) {
            int digit = Integer.parseInt(String.valueOf(bigInteger.charAt(i)));
            int result = digit * multiplier + reminder;
            reminder = 0;
            if (result > 9) {
                reminder = result / 10;
                result = result % 10;
            }
            sb.append(result);
        }
        if (reminder > 0) {
            sb.append(reminder);
        }
        System.out.println(sb.reverse());
    }
}
