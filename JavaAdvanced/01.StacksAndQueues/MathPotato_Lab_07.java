import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class MathPotato_Lab_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] kids = scanner.nextLine().split(" ");
        ArrayDeque<String> queue = new ArrayDeque<>();
        Collections.addAll(queue , kids);
        int count = Integer.parseInt(scanner.nextLine());

        int rotation = 1;
        while (queue.size() > 1){
            for (int i = 1; i < count ; i++) {
                queue.offer(queue.poll());
            }
            if (isPrimeNumber(rotation)){
                System.out.println("Prime " + queue.peek());
            } else {
                System.out.println("Removed " + queue.poll());
            }
            rotation++;
        }

        System.out.println("Last is " + queue.poll());
    }

    public static boolean isPrimeNumber (int n){
        if (n == 1){
            return false;
        }
        for (int i = 2; i < n - 1; i++) {
            if ( n % i == 0){
                return false;
            }
        }
        return true;
    }
}
