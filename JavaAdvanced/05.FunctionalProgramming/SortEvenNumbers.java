import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String numbers = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .filter(num -> num % 2 == 0)
                .map(String::valueOf)
                .collect(Collectors.joining(", "));

        System.out.println(numbers);

        String number2 = Arrays.stream(numbers.split(", "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(", "));

        System.out.println(number2);


    }
}
