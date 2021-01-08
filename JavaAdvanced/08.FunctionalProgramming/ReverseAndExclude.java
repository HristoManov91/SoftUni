import java.util.*;
import java.util.stream.Collectors;

public class ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        int divisibleNumber = Integer.parseInt(scanner.nextLine());

        Collections.reverse(numbers);
        numbers.stream()
                .filter(e -> e % divisibleNumber != 0)
                .forEach(e -> System.out.print(e + " "));

    }
}
