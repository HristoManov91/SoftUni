import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int matrixSize = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[matrixSize][matrixSize];
        for (int i = 0; i < matrixSize; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        int sumPrimeDiagonal = sumPrimeDiagonal(matrix);
        int sumSecondaryDiagonal = sumSecondaryDiagonal(matrix);
        System.out.println(Math.abs(sumPrimeDiagonal - sumSecondaryDiagonal));
    }

    private static int sumSecondaryDiagonal(int[][] matrix) {
        int sum = 0;
        int rowIndex = matrix.length - 1;
        int colIndex = 0;
        while (rowIndex >= 0){
                sum += matrix[rowIndex][colIndex];
                rowIndex--;
                colIndex++;
        }
        return sum;
    }

    private static int sumPrimeDiagonal(int[][] matrix) {
        int sum = 0;
        for (int index = 0; index < matrix.length; index++) {
            sum += matrix[index][index];
        }
        return sum;
    }
}
