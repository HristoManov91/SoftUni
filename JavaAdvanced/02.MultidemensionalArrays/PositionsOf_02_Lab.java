import java.util.Arrays;
import java.util.Scanner;

public class PositionsOf_02_Lab {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matrix =createMatrix(scanner);

        int numberForSearch = Integer.parseInt(scanner.nextLine());

        int count = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == numberForSearch){
                    System.out.println(row + " " + col);
                    count++;
                }
            }
        }
        if (count == 0){
            System.out.println("not found");
        }
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
}
