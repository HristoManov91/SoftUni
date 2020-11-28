import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Map<Integer , Integer> countNumbers = new TreeMap<>();
        for (Integer num : numbers) {
            countNumbers.putIfAbsent(num , 0);
            countNumbers.put(num , countNumbers.get(num) + 1);
        }

        for (Map.Entry<Integer, Integer> num: countNumbers.entrySet()){
            System.out.printf("%d -> %d%n", num.getKey() , num.getValue());
        }
    }
}
