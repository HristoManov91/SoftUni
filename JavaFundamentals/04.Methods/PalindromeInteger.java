import java.util.Scanner;

public class PalindromeInteger {

    static String reverseNumber(String number) {
        String reverseNumber = "";
        for (int i = number.length() - 1; i >= 0; i--) {
            reverseNumber += number.charAt(i);
        }
        return reverseNumber;
    }

    static boolean palindromeNumber(String first, String second) {
        for (int i = 0; i < first.length(); i++) {
            if (first.charAt(i) != second.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String number = scanner.nextLine();
        while (!number.equals("END")) {
            String reverseString = reverseNumber(number);
            System.out.println(palindromeNumber(number, reverseString));

            number = scanner.nextLine();
        }
    }
}
