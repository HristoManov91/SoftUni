import java.util.Scanner;

public class CharsToString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String result = "";
        for (int i = 0; i < 3; i++) {
            String input = scanner.nextLine();
            result = result.concat(input);
        }
        System.out.println(result);
    }
}
