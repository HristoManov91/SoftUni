import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class HotPotato_Lab_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] kids = scanner.nextLine().split(" ");
        ArrayDeque<String> queue = new ArrayDeque<>();
        Collections.addAll(queue , kids);
        int count = Integer.parseInt(scanner.nextLine());

        while (queue.size() > 1){
            for (int i = 1; i < count ; i++) {
                queue.offer(queue.poll());
            }
            System.out.println("Removed " + queue.poll());
        }

        System.out.println("Last is " + queue.poll());
    }
}
