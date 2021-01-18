import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class MaximumElement_Exercise_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        
        int count = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < count; i++) {
            int[] command = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            if (command.length == 2){
                stack.push(command[1]);
            } else if (command[0] == 2){
                stack.pop();
            } else {
                System.out.println(Collections.max(stack));
            }
        }
    }
}
