import java.util.Scanner;

public class Snake {

    static int rowPosition = -1;
    static int colPosition = -1;
    static int foodEaten = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[size][size];

        for (int r = 0; r < size; r++) {
            char[] arr = scanner.nextLine().toCharArray();
            for (int c = 0; c < size; c++) {
                if (arr[c] == 'S') {
                    rowPosition = r;
                    colPosition = c;
                }
                matrix[r][c] = arr[c];
            }
        }
        boolean outOffBounds = false;
        while (!outOffBounds && foodEaten < 10) {
            String command = scanner.nextLine();
            matrix[rowPosition][colPosition] = '.';
            switch (command) {
                case "up":
                    rowPosition--;
                    if (isOutOfBounds(rowPosition, size)) {
                        outOffBounds = true;
                    } else {
                        move(matrix, size);
                    }
                    break;
                case "down":
                    rowPosition++;
                    if (isOutOfBounds(rowPosition, size)) {
                        outOffBounds = true;
                    } else {
                        move(matrix, size);
                    }
                    break;
                case "left":
                    colPosition--;
                    if (isOutOfBounds(colPosition, size)) {
                        outOffBounds = true;
                    } else {
                        move(matrix, size);
                    }
                    break;
                case "right":
                    colPosition++;
                    if (isOutOfBounds(colPosition, size)) {
                        outOffBounds = true;
                    } else {
                        move(matrix, size);
                    }
                    break;
            }
        }

        System.out.println(outOffBounds
                ? "Game over!"
                : "You won! You fed the snake.");
        System.out.println("Food eaten: " + foodEaten);
        printMatrix(matrix);
    }

    private static void move(char[][] matrix, int size) {
        char symbol = matrix[rowPosition][colPosition];
        if (symbol == '*') {
            foodEaten++;
        } else if (symbol == 'B') {
            teleport(matrix, size);
        }
        matrix[rowPosition][colPosition] = 'S';
    }

    private static void teleport(char[][] matrix, int size) {
        matrix[rowPosition][colPosition] = '.';
        boolean searchingOutput = false;
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (matrix[row][col] == 'B') {
                    rowPosition = row;
                    colPosition = col;
                    searchingOutput = true;
                    break;
                }
            }
            if (searchingOutput) {
                break;
            }
        }
    }

    private static boolean isOutOfBounds(int index, int size) {
        return index < 0 || index >= size;
    }

    private static void printMatrix(char[][] matrix) {
        for (char[] chars : matrix) {
            for (int i = 0; i < chars.length; i++) {
                System.out.print(chars[i]);
            }
            System.out.println();
        }
    }
}
