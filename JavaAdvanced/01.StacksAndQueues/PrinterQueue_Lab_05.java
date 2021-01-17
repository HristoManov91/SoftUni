import java.util.ArrayDeque;
import java.util.Scanner;

public class PrinterQueue_Lab_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();

        ArrayDeque<String> queues = new ArrayDeque<>();
        while (!command.equals("print")){
            if (command.equals("cancel")){
                if (queues.isEmpty()){
                    System.out.println("Printer is on standby");
                } else {
                    System.out.println("Canceled " + queues.poll());
                }
            } else {
                queues.offer(command);
            }
            command = scanner.nextLine();
        }

        while (queues.size() > 0){
            System.out.println(queues.poll());
        }
    }
}
