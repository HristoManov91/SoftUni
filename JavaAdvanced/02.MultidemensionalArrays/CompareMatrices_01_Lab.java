import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrices_01_Lab {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] firstMatrix = createMatrix(scanner);
        int[][] secondMatrix = createMatrix(scanner);

        System.out.println(isEqualMatrix(firstMatrix , secondMatrix) ? "equal" : "not equal");
    }

    public static int[][] createMatrix (Scanner scanner){
        int[] matrixParameters = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[][] matrix = new int[matrixParameters[0]][matrixParameters[1]];

        for (int r = 0; r < matrix.length; r++) {
            int[] arr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            matrix[r] = arr;
        }
        return matrix;
    }

    public static boolean isEqualMatrix (int[][] first, int[][] second){
        if (first.length != second.length){
            return false;
        } else {
            for (int row = 0; row < first.length; row++) {
                if (first[row].length != second[row].length){
                    return false;
                }
                for (int col = 0; col < first[row].length; col++) {
                    if (first[row][col] != second[row][col]){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
