import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountCharsInAString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] words = scanner.nextLine().split(" ");

        Map<Character , Integer> charCount = new LinkedHashMap<>();
        for (String word : words) {
            char[] characters = word.toCharArray();
            for (int i = 0; i < characters.length; i++) {
                char character = characters[i];
                charCount.putIfAbsent(character , 0);
                charCount.put(character , charCount.get(character) + 1);
            }
        }
        for (Map.Entry<Character, Integer> element: charCount.entrySet()){
            System.out.println(element.getKey() + " -> " + element.getValue());
        }
    }
}
