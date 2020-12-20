import java.util.Arrays;
import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] matrixDimensions = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(matrixDimensions[0]);
        int cols = Integer.parseInt(matrixDimensions[1]);

        String[][] matrix = new String[rows][cols];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = scanner.nextLine().split(" ");
        }

        String input = scanner.nextLine();
        while (!input.equals("END")) {
            String[] command = input.split(" ");
            if (command[0].equals("swap") && command.length == 5) {
                int rowFirstArr = Integer.parseInt(command[1]);
                int colFirstArr = Integer.parseInt(command[2]);
                int rowSecondArr = Integer.parseInt(command[3]);
                int colSecondArr = Integer.parseInt(command[4]);
                if (isValidIndex(rows, cols, rowFirstArr, colFirstArr, rowSecondArr, colSecondArr)) {
                    String temp = matrix[rowFirstArr][colFirstArr];
                    matrix[rowFirstArr][colFirstArr] = matrix[rowSecondArr][colSecondArr];
                    matrix[rowSecondArr][colSecondArr] = temp;
                    printMatrix(matrix);
                } else {
                    System.out.println("Invalid input!");
                }
            } else {
                System.out.println("Invalid input!");
            }
            input = scanner.nextLine();
        }
    }

    private static void printMatrix(String[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                System.out.print(matrix[r][c] + " ");
            }
            System.out.println();
        }
    }

    private static boolean isValidIndex(int rows, int cols, int rowFirstArr, int colFirstArr,
                                        int rowSecondArr, int colSecondArr) {
        if (rowFirstArr >= rows || rowFirstArr < 0){
            return false;
        }
        if (colFirstArr >= cols || colFirstArr < 0){
            return false;
        }
        if (rowSecondArr >= rows || rowSecondArr < 0){
            return false;
        }
        if (colSecondArr >= cols || colSecondArr < 0){
            return false;
        }
        return true;
    }
}
