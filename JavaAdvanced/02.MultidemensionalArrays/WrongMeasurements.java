import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class WrongMeasurements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rowsOfMatrix = Integer.parseInt(scanner.nextLine());
        
        int[][] matrix = new int[rowsOfMatrix][];

        for (int i = 0; i < rowsOfMatrix; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        String[] indexesOfSpecialNumber = scanner.nextLine().split(" ");
        int indexRow = Integer.parseInt(indexesOfSpecialNumber[0]);
        int indexCol = Integer.parseInt(indexesOfSpecialNumber[1]);

        int specialNumber = matrix[indexRow][indexCol];
        ArrayDeque<Integer> newNumbers = new ArrayDeque<>();

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == specialNumber){
                    int newNumber = 0;
                    if (row - 1 >= 0 && matrix[row - 1][col] != specialNumber){
                        newNumber += matrix[row - 1][col];
                    }
                    if (row + 1 <= matrix.length - 1 && matrix[row + 1][col] != specialNumber){
                        newNumber += matrix[row + 1][col];
                    }
                    if (col - 1 >= 0 && matrix[row][col - 1] != specialNumber){
                        newNumber += matrix[row][col - 1];
                    }
                    if (col + 1 <= matrix[row].length - 1 && matrix[row][col + 1] != specialNumber){
                        newNumber += matrix[row][col + 1];
                    }
                    newNumbers.offer(newNumber);
                }
            }
        }
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c] == specialNumber){
                    System.out.print(newNumbers.poll() + " ");
                } else {
                    System.out.print(matrix[r][c] + " ");
                }
            }
            System.out.println();
        }
    }
}
