import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class Exercise_09_ListOfPredicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int upBound = Integer.parseInt(scanner.nextLine());

        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= upBound ; i++) {
            numbers.add(i);
        }

        int[] numbersToDivisible = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        Predicate<Integer> isValidNumber = number -> {
            for (int num : numbersToDivisible) {
                if (number % num != 0){
                    return false;
                }
            }
            return true;
        };

        numbers.stream().filter(isValidNumber).forEach(n -> System.out.print(n + " "));
    }
}
