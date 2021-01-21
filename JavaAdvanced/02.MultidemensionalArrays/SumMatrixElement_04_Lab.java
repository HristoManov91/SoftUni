import java.util.Arrays;
import java.util.Scanner;

public class SumMatrixElement_04_Lab {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] parameters = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();

        int[][] matrix = createMatrix(parameters[0] , parameters[1] , scanner);

        int sumElements = 0;
        for (int[] arr : matrix) {
            sumElements += Arrays.stream(arr).sum();
        }

        System.out.println(parameters[0]);
        System.out.println(parameters[1]);
        System.out.println(sumElements);
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
