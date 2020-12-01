import java.util.Scanner;

public class Substring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String substring = scanner.nextLine();
        String string = scanner.nextLine();

        while (string.contains(substring)){
            string = string.replaceAll(substring, "");
        }
        System.out.println(string);
    }
}
