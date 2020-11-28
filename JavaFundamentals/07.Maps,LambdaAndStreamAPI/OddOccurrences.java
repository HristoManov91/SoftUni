import java.util.*;
import java.util.stream.Collectors;

public class OddOccurrences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        Map<String , Integer> elements = new LinkedHashMap<>();
        for (String element : input) {
            String newElement = element.toLowerCase();
            elements.putIfAbsent( newElement, 0);
            elements.put(newElement , elements.get(newElement) + 1);
        }
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> e : elements.entrySet()) {
            if (e.getValue() % 2 == 1) {
                result.add(e.getKey());
            }
        }
        System.out.println(result.toString().replaceAll("[\\[\\]]", ""));
    }
}
