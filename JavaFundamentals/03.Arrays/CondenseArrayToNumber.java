import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CondenseArrayToNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt)
                .collect(Collectors.toList());
        while (!(numbers.size() == 1)) {
            for (int i = 0; i < numbers.size() - 1; i++) {
                numbers.set(i , numbers.get(i) + numbers.get(i + 1));
            }
            numbers.remove(numbers.size() - 1);
        }
        System.out.println(numbers.get(0));
    }
}
