import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class EvenAndOddSubtraction {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
//        String[] input = scan.nextLine().split(" ");
        int[] numbers = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int evenSum = 0;
        int oddSum = 0;

        for (int num : numbers) {
            if ( num % 2 == 0){
                evenSum += num;
            } else {
                oddSum += num;
            }
        }
        System.out.printf("%d", evenSum - oddSum);
    }
}
