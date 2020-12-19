import java.util.Arrays;
import java.util.Scanner;

public class MaximumSum2x2Submatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] matrixFormat = scanner.nextLine().split(", ");
        int rows = Integer.parseInt(matrixFormat[0]);
        int cols = Integer.parseInt(matrixFormat[1]);

        int[][] matrix = new int[rows][cols];
        for (int r = 0; r < rows; r++) {
            int[] arr = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
            for (int c = 0; c < cols; c++) {
                matrix[r][c] = arr[c];
            }
        }

        int[][] bestMatrix = new int[2][2];
        int sumBestMatrix = Integer.MIN_VALUE;
        for (int r = 0; r < matrix.length - 1; r++) {
            int sumMatrix;
            for (int c = 0; c < matrix[r].length - 1; c++) {
                sumMatrix = matrix[r][c] + matrix[r][c + 1] + matrix[r + 1][c] + matrix[r + 1][c + 1];
                if (sumMatrix > sumBestMatrix) {
                    sumBestMatrix = sumMatrix;
                    bestMatrix[0][0] = matrix[r][c];
                    bestMatrix[0][1] = matrix[r][c + 1];
                    bestMatrix[1][0] = matrix[r + 1][c];
                    bestMatrix[1][1] = matrix[r + 1][c + 1];
                }
            }
        }
        System.out.println(bestMatrix[0][0] + " " + bestMatrix[0][1]);
        System.out.println(bestMatrix[1][0] + " " + bestMatrix[1][1]);
        System.out.println(sumBestMatrix);
    }
}
