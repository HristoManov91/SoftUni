import java.util.ArrayDeque;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countCommands = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < countCommands; i++) {
            String[] command = scanner.nextLine().split("\\s+");
            switch (command[0]){
                case "1":
                    int numberToPush = Integer.parseInt(command[1]);
                    stack.push(numberToPush);
                    break;
                case "2":
                    stack.pop();
                    break;
                case "3":
                    int maxNumberInAStack = Integer.MIN_VALUE;
                    for (int num : stack) {
                        if (num > maxNumberInAStack){
                            maxNumberInAStack = num;
                        }
                    }
                    System.out.println(maxNumberInAStack);
                    break;
            }
        }
    }
}
