import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Character , Integer> data = new TreeMap<>();

        String input = scanner.nextLine();
        char[] inputToCharArr = input.toCharArray();

        for (char symbol: inputToCharArr) {
            data.putIfAbsent(symbol , 0);
            data.put(symbol , data.get(symbol) + 1);
        }

        for (Map.Entry<Character , Integer> c : data.entrySet()) {
            System.out.println(c.getKey() + ": " + c.getValue() + " time/s");
        }
    }
}
