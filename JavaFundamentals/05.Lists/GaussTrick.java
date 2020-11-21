import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GaussTrick {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int iterationCount = numbers.size() / 2;
        for (int i = 0; i < iterationCount; i++) {
            int newNumber = numbers.get(i) + numbers.get(numbers.size() - 1);
            numbers.set(i , newNumber);
            numbers.remove(numbers.size() - 1);
        }
        for (int num : numbers) {
            System.out.print(num + " ");
        }
    }
}
