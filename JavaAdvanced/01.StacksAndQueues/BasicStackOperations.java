import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        int n = Integer.parseInt(input[0]);
        int s = Integer.parseInt(input[1]);
        int x = Integer.parseInt(input[2]);

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            stack.push(numbers[i]);
        }

        for (int i = 0; i < s; i++) {
            stack.pop();
        }

        if (stack.isEmpty()) {
                System.out.println(0);
        } else {
            if (stack.contains(x)){
                System.out.println("true");
            } else {
                //System.out.println(Collections.min(stack));
                //System.out.println(stack.stream().mapToInt(e -> e).min().orElse(0));
                int smallestElement = Integer.MAX_VALUE;
                for (int num : stack) {
                    if (num < smallestElement) {
                        smallestElement = num;
                    }
                }
                System.out.println(smallestElement);
            }
        }
    }
}
