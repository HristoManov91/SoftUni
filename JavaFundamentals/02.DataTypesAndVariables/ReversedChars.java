import java.util.Scanner;

public class ReversedChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder text = new StringBuilder();

        for (int i = 0; i < 3; i++) {
            char n = scanner.nextLine().charAt(0);
            text.append(n);
        }
        text.reverse();
        for (int i = 0; i < text.length(); i++) {
            System.out.print(text.charAt(i) + " ");
        }
    }
}
