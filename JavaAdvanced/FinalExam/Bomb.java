import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Bomb {

    private static int rowToStart = -1;
    private static int colToStart = -1;
    private static int countOfBombs = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sizeMatrix = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[sizeMatrix][sizeMatrix];

        ArrayDeque<String> commands = Arrays.stream(scanner.nextLine().split(","))
                .collect(Collectors.toCollection(ArrayDeque::new));

        for (int row = 0; row < sizeMatrix; row++) {
            char[] arr = scanner.nextLine().replaceAll("[ ]", "").toCharArray();
            for (int col = 0; col < arr.length; col++) {
                matrix[row][col] = arr[col];
                if (arr[col] == 's'){
                    rowToStart = row;
                    colToStart = col;
                } else if (arr[col] == 'B'){
                    countOfBombs++;
                }
            }
        }
        boolean foundEndPoint = false;
        while (!foundEndPoint && countOfBombs > 0 && !commands.isEmpty()){
            String command = commands.poll();
            switch (command){
                case "up":
                    if (isOutOfBounds(rowToStart - 1 , sizeMatrix)){
                        continue;
                    } else {
                        matrix[rowToStart][colToStart] = '+';
                        rowToStart--;
                        if (matrix[rowToStart][colToStart] == 'B'){
                            System.out.println("You found a bomb!");
                            countOfBombs--;
                        } else if (matrix[rowToStart][colToStart] == 'e'){
                            foundEndPoint = true;
                            break;
                        }
                        matrix[rowToStart][colToStart] = 's';
                    }
                    break;
                case "down":
                    if (isOutOfBounds(rowToStart + 1 , sizeMatrix)){
                        continue;
                    } else {
                        matrix[rowToStart][colToStart] = '+';
                        rowToStart++;
                        if (matrix[rowToStart][colToStart] == 'B'){
                            System.out.println("You found a bomb!");
                            countOfBombs--;
                        } else if (matrix[rowToStart][colToStart] == 'e'){
                            foundEndPoint = true;
                            break;
                        }
                        matrix[rowToStart][colToStart] = 's';
                    }
                    break;
                case "right":
                    if (isOutOfBounds(colToStart + 1 , sizeMatrix)){
                        continue;
                    } else {
                        matrix[rowToStart][colToStart] = '+';
                        colToStart++;
                        if (matrix[rowToStart][colToStart] == 'B'){
                            System.out.println("You found a bomb!");
                            countOfBombs--;
                        } else if (matrix[rowToStart][colToStart] == 'e'){
                            foundEndPoint = true;
                            break;
                        }
                        matrix[rowToStart][colToStart] = 's';
                    }
                    break;
                case "left":
                    if (isOutOfBounds(colToStart - 1 , sizeMatrix)){
                        continue;
                    } else {
                        matrix[rowToStart][colToStart] = '+';
                        colToStart--;
                        if (matrix[rowToStart][colToStart] == 'B'){
                            System.out.println("You found a bomb!");
                            countOfBombs--;
                        } else if (matrix[rowToStart][colToStart] == 'e'){
                            foundEndPoint = true;
                            break;
                        }
                        matrix[rowToStart][colToStart] = 's';
                    }
                    break;
            }
        }
        if (countOfBombs == 0){
            System.out.println("Congratulations! You found all bombs!");
        } else if (foundEndPoint){
            System.out.printf("END! %d bombs left on the field%n", countOfBombs);
        } else if (commands.isEmpty()){
            System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)" ,
                    countOfBombs , rowToStart , colToStart);
        }

    }

    private static boolean isOutOfBounds(int index, int size) {
        return index < 0 || index >= size;
    }
}
