import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class SumOfEvenNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] numbers = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
//        String[] input = scan.nextLine().split(" ");
//        int[] numbers = new int[input.length];
//
//        for (int i = 0; i < input.length; i++) {
//            numbers[i] = Integer.parseInt(input[i]);
//        }
        int evenSum = 0;
        for (int num:numbers) {
            if ( num % 2 == 0){
                evenSum += num;
            }
        }
        System.out.println(evenSum);
    }
}
