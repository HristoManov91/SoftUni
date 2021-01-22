import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference_03_Exercise {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matrix = createMatrix(scanner);

        int sumPrimaryDiagonal = 0;
        int sumSecondaryDiagonal = 0;

        for (int i = 0; i < matrix.length; i++) {
            sumPrimaryDiagonal += matrix[i][i];
            sumSecondaryDiagonal += matrix[matrix.length - 1 - i][i];
        }
        System.out.println(Math.abs(sumPrimaryDiagonal - sumSecondaryDiagonal));
    }

    public static int[][] createMatrix (Scanner scanner){
        int parameter = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[parameter][parameter];

        for (int r = 0; r < matrix.length; r++) {
            int[] arr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            matrix[r] = arr;
        }
        return matrix;
    }
}
