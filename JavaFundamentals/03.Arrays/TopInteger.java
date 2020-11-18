import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class TopInteger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split( " ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < numbers.length - 1; i++) {
            boolean biggestNumber = true;
            for (int j = i + 1; j < numbers.length ; j++) {
                if (numbers[i] <= numbers[j]){
                    biggestNumber = false;
                    break;
                }
            }
            if (biggestNumber){
                System.out.print(numbers[i] + " ");
            }
        }
        System.out.print(numbers[numbers.length - 1]);
    }
}
