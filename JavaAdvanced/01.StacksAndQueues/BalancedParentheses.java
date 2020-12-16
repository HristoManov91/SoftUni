import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        ArrayDeque<Character> stack = new ArrayDeque<>();

        boolean balanced = true;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(' || input.charAt(i) == '[' || input.charAt(i) == '{') {
                stack.push(input.charAt(i));
            } else {
                if (stack.isEmpty()) {
                    balanced = false;
                } else {
                    switch (input.charAt(i)) {
                        case ')':
                            if (stack.pop() != '(') {
                                balanced = false;
                            }
                            break;
                        case ']':
                            if (stack.pop() != '[') {
                                balanced = false;
                            }
                            break;
                        case '}':
                            if (stack.pop() != '{') {
                                balanced = false;
                            }
                            break;
                    }
                }
            }
            if (!balanced) {
                System.out.println("NO");
                break;
            }
        }
        if (balanced) {
            System.out.println("YES");
        }
    }
}
