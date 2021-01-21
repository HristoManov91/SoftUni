import java.util.Arrays;
import java.util.Scanner;

public class IntersectionOfTwoMatrices_03_Lab {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row = Integer.parseInt(scanner.nextLine());
        int col = Integer.parseInt(scanner.nextLine());

        char[][] first = createMatrix(row , col , scanner);
        char[][] second = createMatrix(row , col , scanner);

        for (int r = 0; r < first.length; r++) {
            for (int c = 0; c < first[r].length; c++) {
                if (first[r][c] != second[r][c]){
                    first[r][c] = '*';
                }
            }
        }
        printMatrix(first);
    }

    public static char[][] createMatrix (int row , int col , Scanner scanner){
        char[][] matrix = new char[row][col];

        for (int r = 0; r < matrix.length; r++) {
            char[] arr = scanner.nextLine().replaceAll("[ ]", "").toCharArray();
            matrix[r] = arr;
        }
        return matrix;
    }

    public static void printMatrix (char[][] matrix){
        for (char[] arr : matrix) {
            for (char c : arr) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }
}
