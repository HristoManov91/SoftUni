import java.util.Arrays;
import java.util.Scanner;

public class MaximumSum2x2Submatrix_05_Lab {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] parameters = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();

        int[][] matrix = createMatrix(parameters[0] , parameters[1] , scanner);

        int biggestSum = 0;
        int indexRow = -1;
        int indexCol = -1;

        for (int row = 0; row < matrix.length - 1; row++) {
            for (int col = 0; col < matrix[row].length - 1; col++) {
                int sum = matrix[row][col] + matrix[row][col + 1] + matrix[row + 1][col] + matrix[row + 1][col + 1];
                if (sum > biggestSum){
                    biggestSum = sum;
                    indexRow = row;
                    indexCol = col;
                }
            }
        }
        System.out.printf(
                "%d %d%n" +
                "%d %d%n" +
                "%d", matrix[indexRow][indexCol] , matrix[indexRow][indexCol + 1] ,
                matrix[indexRow + 1][indexCol] , matrix[indexRow + 1][indexCol + 1] , biggestSum);
    }

    public static int[][] createMatrix (int row , int col , Scanner scanner){
        int[][] matrix = new int[row][col];

        for (int r = 0; r < matrix.length; r++) {
            int[] arr = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
            matrix[r] = arr;
        }
        return matrix;
    }
}
