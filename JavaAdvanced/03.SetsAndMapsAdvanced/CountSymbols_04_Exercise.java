import java.util.*;

public class CountSymbols_04_Exercise {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Character , Integer> characterMap = new TreeMap<>();

        char[] arr = scanner.nextLine().toCharArray();
        for (char c : arr) {
            characterMap.putIfAbsent(c , 0);
            characterMap.put(c , characterMap.get(c) + 1);
        }

        for (Map.Entry<Character , Integer> character : characterMap.entrySet()) {
            System.out.printf("%c: %d time/s%n", character.getKey() , character.getValue());
        }
    }
}
