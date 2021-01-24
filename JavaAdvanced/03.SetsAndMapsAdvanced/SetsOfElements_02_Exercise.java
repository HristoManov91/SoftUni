import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class SetsOfElements_02_Exercise {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstCount = scanner.nextInt();
        int secondCount = scanner.nextInt();
        scanner.nextLine();

        Set<Integer> firstSet = createSet(scanner , firstCount);
        Set<Integer> secondSet = createSet(scanner , secondCount);

        firstSet.retainAll(secondSet);

        for (Integer integer : firstSet) {
            System.out.print(integer + " ");
        }

    }

    public static Set<Integer> createSet(Scanner scanner, int count) {
        Set<Integer> set = new LinkedHashSet<>();
        for (int i = 0; i < count; i++) {
            int num = Integer.parseInt(scanner.nextLine());
            set.add(num);
        }
        return set;
    }
}
