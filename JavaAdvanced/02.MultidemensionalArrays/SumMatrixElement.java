import java.util.Arrays;
import java.util.Scanner;

public class SumMatrixElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] matrixFormat = scanner.nextLine().split(", ");
        int rows = Integer.parseInt(matrixFormat[0]);
        int cols = Integer.parseInt(matrixFormat[1]);

        int sum = 0;
        for (int i = 0; i < rows; i++) {
            int[] arr = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
            sum += Arrays.stream(arr).sum();
        }
        System.out.println(rows);
        System.out.println(cols);
        System.out.println(sum);
    }
}
