import java.util.Scanner;

public class Selling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[size][size];

        int rowPosition = -1;
        int colPosition = -1;

        for (int r = 0; r < size; r++) {
            char[] arr = scanner.nextLine().toCharArray();
            for (int c = 0; c < size; c++) {
                if (arr[c] == 'S'){
                    rowPosition = r;
                    colPosition = c;
                }
                matrix[r][c] = arr[c];
            }
        }
        int money = 0;
        boolean outOffBounds = false;
        while (!outOffBounds && money < 50){
            String command = scanner.nextLine();
            matrix[rowPosition][colPosition] = '-';
            switch (command){
                case "up":
                    rowPosition--;
                    if (isOutOfBounds(rowPosition , size)){
                        outOffBounds = true;
                    } else {
                        char symbol = matrix[rowPosition][colPosition];
                        if (Character.isDigit(symbol)){
                            money += Integer.parseInt(String.valueOf(symbol));
                        } else if (symbol == 'O'){
                            matrix[rowPosition][colPosition] = '-';
                            boolean searchingOutput = false;
                            for (int row = 0; row < size; row++) {
                                for (int col = 0; col < size; col++) {
                                    if (matrix[row][col] == 'O'){
                                        rowPosition = row;
                                        colPosition = col;
                                        searchingOutput = true;
                                        break;
                                    }
                                }
                                if (searchingOutput){
                                    break;
                                }
                            }
                        }
                        matrix[rowPosition][colPosition] = 'S';
                    }
                    break;
                case "down":
                    rowPosition++;
                    if (isOutOfBounds(rowPosition , size)){
                        outOffBounds = true;
                    } else {
                        char symbol = matrix[rowPosition][colPosition];
                        if (Character.isDigit(symbol)){
                            money += Integer.parseInt(String.valueOf(symbol));
                        } else if (symbol == 'O'){
                            matrix[rowPosition][colPosition] = '-';
                            boolean searchingOutput = false;
                            for (int row = 0; row < size; row++) {
                                for (int col = 0; col < size; col++) {
                                    if (matrix[row][col] == 'O'){
                                        rowPosition = row;
                                        colPosition = col;
                                        searchingOutput = true;
                                        break;
                                    }
                                }
                                if (searchingOutput){
                                    break;
                                }
                            }
                        }
                        matrix[rowPosition][colPosition] = 'S';
                    }
                    break;
                case "left":
                    colPosition--;
                    if (isOutOfBounds(colPosition , size)){
                        outOffBounds = true;
                    } else {
                        char symbol = matrix[rowPosition][colPosition];
                        if (Character.isDigit(symbol)){
                            money += Integer.parseInt(String.valueOf(symbol));
                        } else if (symbol == 'O'){
                            matrix[rowPosition][colPosition] = '-';
                            boolean searchingOutput = false;
                            for (int row = 0; row < size; row++) {
                                for (int col = 0; col < size; col++) {
                                    if (matrix[row][col] == 'O'){
                                        rowPosition = row;
                                        colPosition = col;
                                        searchingOutput = true;
                                        break;
                                    }
                                }
                                if (searchingOutput){
                                    break;
                                }
                            }
                        }
                        matrix[rowPosition][colPosition] = 'S';
                    }
                    break;
                case "right":
                    colPosition++;
                    if (isOutOfBounds(colPosition , size)){
                        outOffBounds = true;
                    } else {
                        char symbol = matrix[rowPosition][colPosition];
                        if (Character.isDigit(symbol)){
                            money += Integer.parseInt(String.valueOf(symbol));
                        } else if (symbol == 'O'){
                            matrix[rowPosition][colPosition] = '-';
                            boolean searchingOutput = false;
                            for (int row = 0; row < size; row++) {
                                for (int col = 0; col < size; col++) {
                                    if (matrix[row][col] == 'O'){
                                        rowPosition = row;
                                        colPosition = col;
                                        searchingOutput = true;
                                        break;
                                    }
                                }
                                if (searchingOutput){
                                    break;
                                }
                            }
                        }
                        matrix[rowPosition][colPosition] = 'S';
                    }
                    break;
            }
        }

        System.out.println(outOffBounds
                ? "Bad news, you are out of the bakery."
                : "Good news! You succeeded in collecting enough money!");
        System.out.println("Money: " + money);
        printMatrix(matrix);
    }

    private static boolean isOutOfBounds(int index , int size) {
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
