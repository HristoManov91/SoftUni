package GenericCountMethodStrings;

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

        String stringToCompare = scanner.nextLine();
        System.out.println(box.countGreaterThan(stringToCompare));
    }
}
