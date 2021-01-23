import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountRealNumbers_04_Lab {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Double , Integer> numbersCount = new LinkedHashMap<>();

        double[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToDouble(Double::parseDouble).toArray();

        for (double number : numbers) {
            numbersCount.putIfAbsent(number , 0);
            numbersCount.put(number , numbersCount.get(number) + 1);
        }

        numbersCount.forEach((key, value) -> System.out.printf("%.1f -> %d%n", key, value));
    }
}
