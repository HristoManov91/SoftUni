import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class PeriodicTable_03_Exercise {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());

        Set<String> set = new TreeSet<>();
        for (int i = 0; i < count; i++) {
            String[] input = scanner.nextLine().split(" ");
            set.addAll(Arrays.asList(input));
        }

        System.out.println(String.join(" ", set));
    }
}
