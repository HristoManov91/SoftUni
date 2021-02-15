package Exercise_03_StackIterator;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        CustomStack stack = new CustomStack();
        while (!input.equals("END")) {
            if (input.startsWith("Push")) {
                int[] arr = Arrays.stream(input.trim().substring(5).split(", ")).mapToInt(Integer::parseInt).toArray();
                for (int element : arr) {
                    stack.push(element);
                }
            } else {
                try {
                    stack.pop();
                } catch (Exception e){
                    System.out.println(e.getMessage());
                }
            }
            input = scanner.nextLine();
        }
        for (int i = 0; i < 2; i++) {
            for (Integer integer : stack) {
                System.out.println(integer);
            }
        }
    }
}
