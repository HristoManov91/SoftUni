import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CountUppercaseWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Predicate<String> startWithUpperCase = w -> Character.isUpperCase(w.charAt(0));

        List<String> collect = Arrays.stream(scanner.nextLine().split(" "))
                .filter(startWithUpperCase)
                .collect(Collectors.toList());

        System.out.println(collect.size());
        collect.forEach(System.out::println);
    }
}
