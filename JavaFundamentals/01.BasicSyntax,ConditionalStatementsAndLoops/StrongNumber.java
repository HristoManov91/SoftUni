import java.util.Scanner;

public class StrongNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        int sumOfDigit = 0;
        for (int i = 0; i < input.length(); i++) {
            int number = Integer.parseInt(input.charAt(i) + "");
            int fanctorial = 1;
            for (int j = number; j > 1 ; j--) {
                fanctorial *= j;
            }
            sumOfDigit += fanctorial;
        }
        int number = Integer.parseInt(input);
        if ( number == sumOfDigit){
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}
