import java.util.*;
import java.util.stream.Collectors;

public class CountRealNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Double> numbers = Arrays.stream(scanner.nextLine().split(" ")).map(Double::parseDouble).collect(Collectors.toList());

        Map<Double , Integer> result = new LinkedHashMap<>();
        for (Double num : numbers) {
            result.putIfAbsent(num , 0);
            result.put(num , result.get(num) + 1);
        }

        for (Map.Entry<Double, Integer> num : result.entrySet()){
            System.out.printf("%.1f -> %d%n", num.getKey() , num.getValue());
        }
    }
}
