import java.util.Arrays;
import java.util.Scanner;

public class CondenseArrayToNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] array = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        while (array.length > 1) {
            int[] condense = new int[array.length - 1];
            for (int i = 0; i < condense.length; i++) {
                condense[i] = array[i] + array[i + 1];
            }
            array = condense;
        }
        System.out.println(array[0]);
    }
}
