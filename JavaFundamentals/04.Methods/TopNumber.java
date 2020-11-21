import java.util.Scanner;

public class TopNumber {

    static boolean sumOfCharDivisibleByEight (String number){
        int sumOfDigits = 0;
        for (int i = 0; i < number.length(); i++) {
            int digit = Integer.parseInt(String.valueOf(number.charAt(i)));
            sumOfDigits += digit;
        }
        return sumOfDigits % 8 == 0;
    }

    static boolean containsOddDigit (String number){
        for (int i = 0; i < number.length(); i++) {
            int currentDigit = Integer.parseInt(String.valueOf(number.charAt(i)));
            if (currentDigit % 2 == 1){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberInput = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= numberInput ; i++) {
            String number = String.valueOf(i);
            if (sumOfCharDivisibleByEight(number) && containsOddDigit(number)){
                System.out.println(i);
            }
        }
    }
}
