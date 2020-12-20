import java.util.Arrays;
import java.util.Scanner;

public class MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] matrixSize = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(matrixSize[0]);
        int cols = Integer.parseInt(matrixSize[1]);

        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int bestSumOfMatrix = Integer.MIN_VALUE;
        int[][] bestMatrix = new int[3][3];
        for (int row = 0; row <= matrix.length - 3; row++) {
            for (int col = 0; col <= matrix[row].length - 3; col++) {
                int[][] matrix3x3 = matrix3x3(matrix , row , col);
                int sumOfMatrix = sumOfElementsInMatrix(matrix3x3);
                if (sumOfMatrix > bestSumOfMatrix){
                    bestSumOfMatrix = sumOfMatrix;
                    bestMatrix = matrix3x3;
                }
            }
        }
        System.out.println("Sum = " + bestSumOfMatrix);
        printMatrix(bestMatrix);
    }

    private static void printMatrix(int[][] bestMatrix) {
        for (int r = 0; r < bestMatrix.length; r++) {
            for (int c = 0; c < bestMatrix[r].length; c++) {
                System.out.print(bestMatrix[r][c] + " ");
            }
            System.out.println();
        }
    }

    private static int sumOfElementsInMatrix(int[][] matrix3x3) {
        int sum = 0;
        for (int i = 0; i < matrix3x3.length; i++) {
            for (int j = 0; j < matrix3x3[i].length; j++) {
                sum += matrix3x3[i][j];
            }
        }
        return sum;
    }

    private static int[][] matrix3x3(int[][] matrix, int row, int col) {
        int[][] littleMatrix = new int[3][3];
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                littleMatrix[r][c] = matrix[row + r][col + c];
            }
        }
        return littleMatrix;
    }
}
