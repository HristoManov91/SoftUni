import java.util.Scanner;

public class ReverseArrayOfString {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        String[] elements = input.split(" ");

        for (int i = 0; i < elements.length / 2; i++) {
            String tmp = elements[i];
            elements[i] = elements[elements.length - 1 - i];
            elements[elements.length - 1 - i] = tmp;
        }

        for (String element:elements) {
            System.out.print(element + " ");
        }
    }
}
