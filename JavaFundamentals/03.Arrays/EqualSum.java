import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class EqualSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int specialIndex = -1;
        for (int i = 0; i < numbers.length; i++) {
            int leftSum = 0;
            int rightSum = 0;
            for (int j = 0; j < i; j++) {
                leftSum += numbers[j];
            }
            for (int k = i + 1; k < numbers.length; k++) {
                rightSum += numbers[k];
            }
            if ( leftSum == rightSum){
                specialIndex = i;
                break;
            }
        }
        if (specialIndex == -1){
            System.out.println("no");
        } else {
            System.out.println(specialIndex);
        }
    }
}
