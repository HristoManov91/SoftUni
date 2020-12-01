import java.util.Scanner;

public class TextFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] bannedWord = scanner.nextLine().split(", ");
        String text = scanner.nextLine();

        for (String word : bannedWord) {
            String asterisks = asterisksCodeByWord(word);
            text = text.replaceAll(word , asterisks);
        }
        System.out.println(text);
    }
    private static String asterisksCodeByWord ( String bannedWord ){
        String output = "";
        for (int i = 0; i < bannedWord.length(); i++) {
            output += "*";
        }
        return output;
    }
}
