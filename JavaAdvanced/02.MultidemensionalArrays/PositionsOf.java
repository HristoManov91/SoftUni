import java.util.Arrays;
import java.util.Scanner;

public class PositionsOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] tokens = scanner.nextLine().split("\\s+");

        int rows = Integer.parseInt(tokens[0]);
        int cols = Integer.parseInt(tokens[1]);

        int[][] matrix = new int[rows][cols];

        for (int r = 0; r < rows; r++) {
            int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            for (int c = 0; c < cols; c++) {
                matrix[r][c] = numbers[c];
            }
        }
        int numberToFindPositions = Integer.parseInt(scanner.nextLine());

        boolean numberIsFind = false;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (matrix[r][c] == numberToFindPositions){
                    System.out.println(r + " " + c);
                    numberIsFind = true;
                }
            }
        }
        if (!numberIsFind){
            System.out.println("not found");
        }
    }
}
