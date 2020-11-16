import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int totalValue = 0;
        for (int num: numbers) {
            totalValue += num;
        }
        double averageValue = totalValue * 1.0 / numbers.size();

        List<Integer> result = new ArrayList<>();
        for (int num: numbers) {
            if (num > averageValue){
                result.add(num);
            }
        }
        if (result.size() > 0){
            result.stream()
                    .sorted((n1 , n2) -> n2.compareTo(n1))
                    .limit(5)
                    .forEach(n -> System.out.print(n + " "));
        } else {
            System.out.println("No");
        }
    }
}
