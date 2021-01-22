import java.util.Scanner;

public class FillTheMatrix_01_Exercise {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] data = scanner.nextLine().split(", ");

        int parameterForMatrix = Integer.parseInt(data[0]);
        String pattern = data[1];

        int[][] matrix = new int[parameterForMatrix][parameterForMatrix];

        int number = 1;

        if (pattern.equals("A")) {
            for (int col = 0; col < parameterForMatrix; col++) {
                for (int row = 0; row < parameterForMatrix; row++) {
                    matrix[row][col] = number;
                    number++;
                }
            }
        } else if (pattern.equals("B")) {
            for (int col = 0; col < parameterForMatrix; col++) {
                if (col % 2 == 0) {
                    for (int row = 0; row < parameterForMatrix; row++) {
                        matrix[row][col] = number;
                        number++;
                    }
                } else {
                    for (int row = parameterForMatrix - 1; row >= 0 ; row--) {
                        matrix[row][col] = number;
                        number++;
                    }
                }
            }
        }
        printMatrix(matrix);
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] arr : matrix) {
            for (int n : arr) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }
}
