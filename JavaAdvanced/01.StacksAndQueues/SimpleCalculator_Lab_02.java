import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class SimpleCalculator_Lab_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");

        ArrayDeque<String> stack = new ArrayDeque<>();

        Collections.addAll(stack , input);

        while (stack.size() > 1){
            int firstElement = Integer.parseInt(stack.pop());
            String operator = stack.pop();
            int secondElement = Integer.parseInt(stack.pop());

            if (operator.equals("+")){
                stack.push(String.valueOf(firstElement + secondElement));
            } else {
                stack.push(String.valueOf(firstElement - secondElement));
            }
        }
        System.out.println(stack.pop());
    }
}
