import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class PredicateForNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = Integer.parseInt(scanner.nextLine());
        Predicate<String> validName = n -> n.length() <= length;

        String[] names = scanner.nextLine().split("\\s+");
        Arrays.stream(names).filter(validName).forEach(System.out::println);
    }
}
