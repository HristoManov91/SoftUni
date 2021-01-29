import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class ListOfPredicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lastNumber = Integer.parseInt(scanner.nextLine());

        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= lastNumber; i++) {
            numbers.add(i);
        }

        int[] divisibleNumbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        Predicate<Integer> isDivisible = n -> {
            for (int num : divisibleNumbers) {
                if ( n % num != 0){
                    return false;
                }
            }
            return true;
        };

        numbers.stream().filter(isDivisible).forEach(num -> System.out.print(num + " "));
    }
}
