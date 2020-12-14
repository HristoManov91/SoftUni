import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowseHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        ArrayDeque<String> browserHistoryStack = new ArrayDeque<>();
//        ArrayDeque<String> browserHistoryQueue = new ArrayDeque<>();
//
//        String current = "";
//
//        String command = scanner.nextLine();
//        while (!command.equals("Home")){
//            if (command.equals("back")){
//                if (browserHistoryStack.isEmpty()){
//                    System.out.println("no previous URLs");
//                    command = scanner.nextLine();
//                    continue;
//                } else {
//                    browserHistoryQueue.offer(current);
//                    current = browserHistoryStack.pop();
//                }
//            } else if (command.equals("forward")){
//                if (browserHistoryQueue.isEmpty()){
//                    System.out.println("no next URLs");
//                    command = scanner.nextLine();
//                    continue;
//                } else {
//                    current = browserHistoryQueue.poll();
//                    System.out.println(current);
//                    command = scanner.nextLine();
//                    continue;
//                }
//            } else {
//                if (!current.isEmpty()){
//                    browserHistoryStack.push(current);
//                }
//                current = command;
//            }
//            command = scanner.nextLine();
//            System.out.println(current);
//        }
        ArrayDeque<String> browserHistory = new ArrayDeque<>();
        ArrayDeque<String> forwardHistory = new ArrayDeque<>();

        String command;

        while (!"Home".equals(command = scanner.nextLine())) {

            if (command.equals("back")) {
                if (browserHistory.size() < 2) {
                    System.out.println("no previous URLs");
                } else {
                    forwardHistory.addFirst(browserHistory.peek());
                    browserHistory.pop();
                    System.out.println(browserHistory.peek());
                }
            } else if (command.equals("forward")) {
                if (forwardHistory.size() < 1) {
                    System.out.println("no next URLs");
                } else {
                    System.out.println(forwardHistory.peek());
                    browserHistory.push(forwardHistory.pop());
                }
            } else {
                System.out.println(command);
                browserHistory.push(command);
                forwardHistory.clear();
            }
        }
    }
}
