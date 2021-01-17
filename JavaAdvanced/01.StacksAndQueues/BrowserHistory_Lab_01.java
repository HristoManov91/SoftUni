
import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory_Lab_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> history = new ArrayDeque<>();
        String currentUrl = "";

        String command = scanner.nextLine();
        while (!command.equals("Home")) {
            if (command.equals("back")) {
                if (history.isEmpty()) {
                    System.out.println("no previous URLs");
                } else {
                    currentUrl = history.pop();
                    System.out.println(currentUrl);
                }
            } else {
                if (!currentUrl.isEmpty()) {
                    history.push(currentUrl);
                }
                currentUrl = command;
                System.out.println(currentUrl);
            }
            command = scanner.nextLine();
        }
    }
}
