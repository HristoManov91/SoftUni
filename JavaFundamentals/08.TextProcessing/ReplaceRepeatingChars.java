import java.util.Scanner;

public class ReplaceRepeatingChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        StringBuilder sb = new StringBuilder();

        char character = input.charAt(0);
        sb.append(character);
        for (int i = 1; i < input.length(); i++) {
            char newCharacter = input.charAt(i);
            if (newCharacter != character){
                sb.append(newCharacter);
                character = newCharacter;
            }
        }
        System.out.println(sb);
    }
}
