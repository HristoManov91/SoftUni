import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] informationForMatrix = scanner.nextLine().split(", ");
        int row = Integer.parseInt(informationForMatrix[0]);
        char pattern = informationForMatrix[1].charAt(0);

        int[][] matrix = new int[row][];
        if (pattern == 'A'){
            matrix = createdMatrixWithPatternA(row);
        } else if (pattern == 'B'){
            matrix = createdMatrixWithPatternB(row);
        }
        printingMatrix(matrix);
    }

    public static void printingMatrix(int[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                System.out.print(matrix[r][c] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] createdMatrixWithPatternB(int row) {
        int[][] matrix = new int[row][row];
        int number = 1;
        for (int c = 0; c < matrix.length; c++) {
            if (c % 2 == 0){
                for (int r = 0; r < matrix.length; r++) {
                    matrix[r][c] = number;
                    number++;
                }
            } else {
                for (int r = matrix.length - 1; r >= 0 ; r--) {
                    matrix[r][c] = number;
                    number++;
                }
            }
        }
        return matrix;
    }

    private static int[][] createdMatrixWithPatternA(int row) {
        int[][] matrix = new int[row][row];
        int number = 1;
        for (int c = 0; c < matrix.length; c++) {
            for (int r = 0; r < matrix.length; r++) {
                matrix[r][c] = number;
                number++;
            }
        }
        return matrix;
    }
}
