import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowseHistoryUpgrade_Lab_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> backHistory = new ArrayDeque<>();

        ArrayDeque<String> forwardHistory = new ArrayDeque<>();

        String command = scanner.nextLine();
        while (!command.equals("Home")) {
            if (command.equals("back")) {
                if (backHistory.size() < 2) {
                    System.out.println("no previous URLs");
                } else {
                    forwardHistory.offer(backHistory.pop());
                    System.out.println(backHistory.peek());
                }
            }
            else if (command.equals("forward")){
                if (forwardHistory.isEmpty()){
                    System.out.println("no next URLs");
                } else {
                    System.out.println(forwardHistory.peek());
                    backHistory.push(forwardHistory.pop());
                }
            } else {
                System.out.println(command);
                backHistory.push(command);
                forwardHistory.clear();
            }
            command = scanner.nextLine();
        }
    }
}
