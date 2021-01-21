import java.util.Arrays;
import java.util.Scanner;

public class WrongMeasurements_08_Lab {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matrix = createMatrix(scanner);

        int[] arr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int indexRow = arr[0];
        int indexCol = arr[1];

        int wrongValue = matrix[indexRow][indexCol];

        int[][] fixedMatrix = new int[matrix.length][matrix[0].length];

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == wrongValue){
                    int fixedValue = 0;
                    if (row - 1 >= 0 && matrix[row - 1][col] != wrongValue){
                        fixedValue += matrix[row - 1][col];
                    }
                    if (row + 1 < matrix.length && matrix[row + 1][col] != wrongValue){
                        fixedValue += matrix[row + 1][col];
                    }
                    if (col - 1 >= 0 && matrix[row][col - 1] != wrongValue){
                        fixedValue += matrix[row][col - 1];
                    }
                    if (col + 1 < matrix[row].length && matrix[row][col + 1] != wrongValue){
                        fixedValue += matrix[row][col + 1];
                    }
                    fixedMatrix[row][col] = fixedValue;
                } else {
                    fixedMatrix[row][col] = matrix[row][col];
                }
            }
        }
        printMatrix(fixedMatrix);
    }

    public static int[][] createMatrix (Scanner scanner){
        int parameter = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[parameter][];

        for (int r = 0; r < matrix.length; r++) {
            int[] arr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            matrix[r] = arr;
        }
        return matrix;
    }

    public static void printMatrix (int[][] matrix){
        for (int[] arr : matrix) {
            for (int n : arr) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }
}
