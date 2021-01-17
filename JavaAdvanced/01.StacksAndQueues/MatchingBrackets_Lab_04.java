import java.util.ArrayDeque;
import java.util.Scanner;

public class MatchingBrackets_Lab_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        ArrayDeque<Integer> indexOfBracket = new ArrayDeque<>();

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '('){
                indexOfBracket.push(i);
            } else if (input.charAt(i) == ')'){
                System.out.println(input.substring(indexOfBracket.pop() , i + 1));
            }
        }
    }
}
