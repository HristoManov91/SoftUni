import java.util.ArrayDeque;
import java.util.Scanner;

public class MatchPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] children = scanner.nextLine().split("\\s+");
        int n = Integer.parseInt(scanner.nextLine());

        ArrayDeque<String> queue = new ArrayDeque<>();

        for (String child : children) {
            queue.offer(child);
        }

        int cycle = 1;
        while (queue.size() > 1) {
            for (int i = 1; i < n; i++) {
                queue.offer(queue.poll());
            }
            if (isPrime(cycle) && cycle != 1) {
                System.out.println("Prime " + queue.peek());
            } else {
                System.out.println("Removed " + queue.poll());
            }
            cycle++;
        }
        System.out.println("Last is " + queue.peek());
    }

    static boolean isPrime(Integer number) {
        boolean isPrimer = true;
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                isPrimer = false;
                break;
            }
        }
        return isPrimer;
    }
}
