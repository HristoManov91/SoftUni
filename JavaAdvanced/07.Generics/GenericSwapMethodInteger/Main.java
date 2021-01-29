package GenericSwapMethodInteger;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());

        Box<Integer> box = new Box<>();

        for (int i = 0; i < count; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            box.addElement(number);
        }

        int fromIndex = scanner.nextInt();
        int toIndex = scanner.nextInt();
        scanner.nextLine();

        box.swapElements(fromIndex , toIndex);

        System.out.println(box);
    }
}
