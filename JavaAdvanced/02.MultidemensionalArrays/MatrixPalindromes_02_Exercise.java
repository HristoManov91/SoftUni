import java.util.Arrays;
import java.util.Scanner;

public class MatrixPalindromes_02_Exercise {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] parametersForMatrix = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int row = parametersForMatrix[0];
        int col = parametersForMatrix[1];

        String[][] matrix = new String[row][col];

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                StringBuilder sb = new StringBuilder();
                        sb.append((char) (97 + r));
                        sb.append((char) (97 + r + c));
                        sb.append((char) (97 + r));
                matrix[r][c] = sb.toString();
            }
        }
        printMatrix(matrix);

    }

    public static void printMatrix(String[][] matrix) {
        for (String[] arr : matrix) {
            for (String n : arr) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }
}
