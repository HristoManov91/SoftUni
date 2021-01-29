import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Lab_01_SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());

        System.out.println(numbers.toString().replaceAll("[\\[\\]]", ""));
        Collections.sort(numbers);
        if (numbers.isEmpty()){
            System.out.println("(no output)");
        }
        System.out.println(numbers.toString().replaceAll("[\\[\\]]", ""));
    }
}
