import java.util.Arrays;
import java.util.Scanner;

public class EqualArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers1 = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] numbers2 = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        boolean isEqual = true;
        int differentIndex = -1;
        for (int i = 0; i < numbers1.length; i++) {
            if (numbers1[i] != numbers2[i]){
                isEqual = false;
                differentIndex = i;
                break;
            }
        }
        if (isEqual){
            int sum = 0;
            for (int num : numbers1) {
                sum+=num;
            }
            System.out.printf("Arrays are identical. Sum: %d", sum);
        } else {
            System.out.printf("Arrays are not identical. Found difference at %d index.", differentIndex);
        }
    }
}
