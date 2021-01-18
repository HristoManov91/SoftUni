import java.util.ArrayDeque;
import java.util.Scanner;

public class BasicStackOperations_Exercise_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");

        int elementsToPushOnTheStack = Integer.parseInt(input[0]);
        int numberOfElementsToPopFromTheStack = Integer.parseInt(input[1]);
        int numberToSearch = Integer.parseInt(input[2]);

        String[] numbers = scanner.nextLine().split(" ");

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < elementsToPushOnTheStack; i++) {
            stack.push(Integer.parseInt(numbers[i]));
        }

        for (int i = 0; i < numberOfElementsToPopFromTheStack; i++) {
            stack.pop();
        }

        if (stack.isEmpty()){
            System.out.println(0);
        } else if (stack.contains(numberToSearch)) {
            System.out.println("true");
        }
        else {
            System.out.println(stack.stream().mapToInt(e -> e).min().getAsInt());
        }
    }
}
