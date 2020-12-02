import java.util.Scanner;

public class CaesarCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        char[] arrayOfInput = input.toCharArray();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arrayOfInput.length; i++) {
            char symbol = (char) (arrayOfInput[i] + 3);
            sb.append(symbol);
        }
        System.out.println(sb);
    }
}
