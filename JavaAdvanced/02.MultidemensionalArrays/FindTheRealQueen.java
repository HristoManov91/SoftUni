import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FindTheRealQueen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] matrix = new char[8][8];

        for (int i = 0; i < 8; i++) {
            char[] arr = scanner.nextLine().replaceAll("[ ]", "").toCharArray();
            matrix[i] = arr;
        }
        boolean isRealQueen = false;
        int rowQ = -1;
        int colQ = -1;
        for (int row = 0; row < matrix.length; row++) {
            if (isRealQueen) {
                break;
            }
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'q') {
                    if (checkRow(matrix[row]) && checkCol(matrix, col) && checkDiagonals(matrix, row, col)) {
                        rowQ = row;
                        colQ = col;
                        isRealQueen = true;
                        break;
                    }
                }
            }
        }

        System.out.println(rowQ + " " + colQ);
    }

    private static boolean checkDiagonals(char[][] matrix, int row, int col) {
        int parameter = 1;
        while (row - parameter >= 0 && col - parameter >= 0) {
            if (matrix[row - parameter][col - parameter] == 'q') {
                return false;
            }
            parameter++;
        }

        parameter = 1;
        while (row + parameter < 8 && col + parameter < 8) {
            if (matrix[row + parameter][col + parameter] == 'q') {
                return false;
            }
            parameter++;
        }

        parameter = 1;
        while (row + parameter < 8 && col - parameter >= 0) {
            if (matrix[row + parameter][col - parameter] == 'q') {
                return false;
            }
            parameter++;
        }

        parameter = 1;
        while (row - parameter >= 0 && col + parameter < 8) {
            if (matrix[row - parameter][col + parameter] == 'q') {
                return false;
            }
            parameter++;
        }
        return true;
    }

    private static boolean checkCol(char[][] matrix, int col) {
        int countQueen = 0;
        for (int row = 0; row < matrix.length; row++) {
            if (matrix[row][col] == 'q') {
                countQueen++;
                if (countQueen > 1) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean checkRow(char[] matrix) {
        int countQueen = 0;
        for (char c : matrix) {
            if (c == 'q') {
                countQueen++;
                if (countQueen > 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
