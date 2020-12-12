import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> browserHistory = new ArrayDeque<>();

        String current = "";

        String command = scanner.nextLine();
        while (!command.equals("Home")){
            if (command.equals("back")){
                if (browserHistory.isEmpty()){
                    System.out.println("no previous URLs");
                    command = scanner.nextLine();
                    continue;
                } else {
                    current = browserHistory.pop();
                }
            } else {
                if (!current.isEmpty()){
                    browserHistory.push(current);
                }
                current = command;
            }
            command = scanner.nextLine();
            System.out.println(current);
        }
    }
}
