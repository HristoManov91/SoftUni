import java.util.Scanner;
import java.util.function.Predicate;

public class Lab_06_FindEvenOrOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] boundaries = scanner.nextLine().split(" ");
        int downBound = Integer.parseInt(boundaries[0]);
        int upBound = Integer.parseInt(boundaries[1]);

        String condition = scanner.nextLine();
        Predicate<Integer> isValidNumber = createPredicate(condition);

        for (int i = downBound; i <= upBound ; i++) {
            if (isValidNumber.test(i)){
                System.out.print(i + " ");
            }
        }
    }

    private static Predicate<Integer> createPredicate(String condition) {
        Predicate<Integer> predicate = null;
        predicate = condition.equals("even") ? n -> n % 2 == 0 : n -> n % 2 == 1 || n % 2 == -1;
        return predicate;
    }
}
