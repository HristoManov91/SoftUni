import java.util.Scanner;

public class TriplesOfLatinLetters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int digit = Integer.parseInt(scanner.nextLine());

        for (int i = 97; i < 97 + digit; i++) {
            for (int j = 97; j < 97 + digit; j++) {
                for (int k = 97; k < 97 + digit; k++) {
                    System.out.printf("%c%c%c%n", i , j , k);
                }
            }
        }
    }
}
