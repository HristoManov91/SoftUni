import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses_Exercise_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] input = scanner.nextLine().toCharArray();

        ArrayDeque<Character> stack = new ArrayDeque<>();
        boolean isBalanced = true;
        for (int i = 0; i < input.length; i++) {
            if (input[i] == '{' || input[i] == '[' || input[i] == '('){
                stack.push(input[i]);
            } else {
                if ( stack.isEmpty()){
                    isBalanced = false;
                    break;
                }
                switch (input[i]){
                    case '}':
                        if (stack.pop() != '{'){
                            isBalanced = false;
                        }
                        break;
                    case ']':
                        if (stack.pop() != '['){
                            isBalanced = false;
                        }
                        break;
                    case ')':
                        if (stack.pop() != '('){
                            isBalanced = false;
                        }
                        break;
                }
                if (!isBalanced){
                    break;
                }
            }
        }
        System.out.println(isBalanced ? "YES" : "NO");
    }
}
