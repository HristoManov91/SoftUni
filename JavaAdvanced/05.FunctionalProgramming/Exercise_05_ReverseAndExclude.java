import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Exercise_05_ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        int divisibleNumber = Integer.parseInt(scanner.nextLine());

        Predicate<Integer> predicate = n -> n % divisibleNumber != 0;

        numbers = numbers.stream().filter(predicate).collect(Collectors.toList());
        Collections.reverse(numbers);
        numbers.forEach(n -> System.out.print(n + " "));
    }
}
