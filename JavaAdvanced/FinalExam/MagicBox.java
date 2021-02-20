import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MagicBox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> first = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> second = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(second::push);

        int value = 0;
        while (!first.isEmpty() && !second.isEmpty()) {
            int itemFromFirst = first.poll();
            int itemFromSecond = second.pop();
            int sum = itemFromFirst + itemFromSecond;
            if (sum % 2 == 0){
                value += sum;
            } else {
                first.offerFirst(itemFromFirst);
                first.offer(itemFromSecond);
            }
        }

        System.out.println(first.isEmpty() ? "First magic box is empty." : "Second magic box is empty.");
        System.out.println(value >= 90
                ? String.format("Wow, your prey was epic! Value: %d", value)
                : String.format("Poor prey... Value: %d", value));
    }
}
