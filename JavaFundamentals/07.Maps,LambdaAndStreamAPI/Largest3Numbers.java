import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Largest3Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .sorted((f , s) -> s.compareTo(f))
                .limit(3)
                .forEach(n -> System.out.print(n + " "));
    }
}
