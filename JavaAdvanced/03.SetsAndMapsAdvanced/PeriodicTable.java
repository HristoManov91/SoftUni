import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());
        Set<String> elements = new TreeSet<>();

        for (int i = 0; i < count; i++) {
            String[] input = scanner.nextLine().split(" ");
            elements.addAll(Arrays.asList(input));
        }
        System.out.println(String.join(" " , elements));
    }
}
