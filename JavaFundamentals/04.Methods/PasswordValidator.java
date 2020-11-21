import java.util.Scanner;

public class PasswordValidator {

    static boolean passwordLength(String password) {
        if (6 <= password.length() && password.length() <= 10) {
            return true;
        }
        System.out.println("Password must be between 6 and 10 characters");
        return false;
    }

    static boolean consistsOnlyLettersAndDigits(String password) {
        for (int i = 0; i < password.length(); i++) {
            if (!Character.isLetterOrDigit(password.charAt(i))) {
                System.out.println("Password must consist only of letters and digits");
                return false;
            }
        }
        return true;
    }

    static boolean leasTwoDigits(String password) {
        int digit = 0;
        for (int i = 0; i < password.length(); i++) {
            if (Character.isDigit(password.charAt(i))) {
                digit++;
                if (digit == 2) {
                    return true;
                }
            }
        }
        System.out.println("Password must have at least 2 digits");
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputPassword = scanner.nextLine();

        boolean firstRule = passwordLength(inputPassword);
        boolean secondRule = consistsOnlyLettersAndDigits(inputPassword);
        boolean thirdRule = leasTwoDigits(inputPassword);

        if (firstRule && secondRule && thirdRule) {
            System.out.println("Password is valid");
        }
    }
}
