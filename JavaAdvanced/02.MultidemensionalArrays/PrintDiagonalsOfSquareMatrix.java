import java.util.Arrays;
import java.util.Scanner;

public class PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int matrixSize = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[matrixSize][matrixSize];
        for (int r = 0; r < matrixSize; r++) {
            matrix[r] = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }

        for (int index = 0; index < matrixSize; index++) {
            System.out.print(matrix[index][index] + " ");
        }
        System.out.println();
        for (int index = 0; index < matrixSize; index++) {
            System.out.print(matrix[(matrixSize - 1) - index][index] + " ");
        }
    }
}
