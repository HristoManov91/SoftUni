import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class ReverseNumbersWithStack_01_Exercise {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");

        ArrayDeque<String> stack = new ArrayDeque<>();
        for (String e : input) {
            stack.push(e);
        }

        while (!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }
    }
}
