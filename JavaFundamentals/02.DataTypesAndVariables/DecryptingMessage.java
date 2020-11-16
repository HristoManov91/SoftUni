import java.util.Scanner;

public class DecryptingMessage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int key = Integer.parseInt(scanner.nextLine());
        int countCharacter = Integer.parseInt(scanner.nextLine());

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < countCharacter; i++) {
            char character = (char) (scanner.nextLine().charAt(0) + key);
            result.append(character);
        }
        System.out.println(result);
    }
}
