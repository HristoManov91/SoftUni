import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class BasicQueueOperations_Exercise_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");

        int elementsToPushOnTheStack = Integer.parseInt(input[0]);
        int numberOfElementsToPollFromTheStack = Integer.parseInt(input[1]);
        int numberToSearch = Integer.parseInt(input[2]);

        String[] numbers = scanner.nextLine().split(" ");

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < elementsToPushOnTheStack; i++) {
            queue.offer(Integer.parseInt(numbers[i]));
        }

        for (int i = 0; i < numberOfElementsToPollFromTheStack; i++) {
            queue.poll();
        }

        if (queue.contains(numberToSearch)) {
            System.out.print("true");
        } else {
            System.out.println(queue.stream().mapToInt(e -> e).min().orElse(0));
        }
    }
}
