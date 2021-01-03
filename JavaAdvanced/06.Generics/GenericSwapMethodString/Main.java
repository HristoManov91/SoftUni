package GenericSwapMethodString;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());

        Box<String> box = new Box<>();

        for (int i = 0; i < count; i++) {
            String input = scanner.nextLine();
            box.addElement(input);
        }

        int fromIndex = scanner.nextInt();
        int toIndex = scanner.nextInt();
        scanner.nextLine();

        box.swapElements(fromIndex , toIndex);

        System.out.println(box);
    }
}
