import java.util.Arrays;
import java.util.Scanner;

public class Bee {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sizeSquareMatrix = Integer.parseInt(scanner.nextLine());

        int beeRow = -1;
        int beeCol = -1;
        char[][] beeTerritory = new char[sizeSquareMatrix][sizeSquareMatrix];
        for (int i = 0; i < sizeSquareMatrix; i++) {
            String line = scanner.nextLine();
            if (line.indexOf('B') != -1){
                beeRow = i;
                beeCol = line.indexOf('B');
            }
            beeTerritory[i] = line.toCharArray();

        }

        boolean beeLost = false;
        int countPollinateFlowers = 0;

        String input = scanner.nextLine();
        while (!beeLost && !input.equals("End")){
            beeTerritory[beeRow][beeCol] = '.';
            char symbol;
            switch (input){
                case "up":
                    beeRow--;
                    if (beeOutOfBound(beeRow , sizeSquareMatrix)){
                        beeLost  = true;
                        break;
                    }
                    symbol = beeTerritory[beeRow][beeCol];
                    if (symbol == 'f'){
                        countPollinateFlowers++;
                    } else if (symbol == 'O'){
                        beeTerritory[beeRow][beeCol] = '.';
                        beeRow--;
                        if (beeOutOfBound(beeRow , sizeSquareMatrix)){
                            beeLost = true;
                            break;
                        }
                        symbol = beeTerritory[beeRow][beeCol];
                        if (symbol == 'f'){
                            countPollinateFlowers++;
                        }
                    }
                    beeTerritory[beeRow][beeCol] = 'B';
                    break;
                case "down":
                    beeRow++;
                    if (beeOutOfBound(beeRow , sizeSquareMatrix)){
                        beeLost  = true;
                        break;
                    }
                    symbol = beeTerritory[beeRow][beeCol];
                    if (symbol == 'f'){
                        countPollinateFlowers++;
                    } else if (symbol == 'O'){
                        beeTerritory[beeRow][beeCol] = '.';
                        beeRow++;
                        if (beeOutOfBound(beeRow , sizeSquareMatrix)){
                            beeLost = true;
                            break;
                        }
                        symbol = beeTerritory[beeRow][beeCol];
                        if (symbol == 'f'){
                            countPollinateFlowers++;
                        }
                    }
                    beeTerritory[beeRow][beeCol] = 'B';
                    break;
                case "left":
                    beeCol--;
                    if (beeOutOfBound(beeCol , sizeSquareMatrix)){
                        beeLost  = true;
                        break;
                    }
                    symbol = beeTerritory[beeRow][beeCol];
                    if (symbol == 'f'){
                        countPollinateFlowers++;
                    } else if (symbol == 'O'){
                        beeTerritory[beeRow][beeCol] = '.';
                        beeCol--;
                        if (beeOutOfBound(beeRow , sizeSquareMatrix)){
                            beeLost = true;
                            break;
                        }
                        symbol = beeTerritory[beeRow][beeCol];
                        if (symbol == 'f'){
                            countPollinateFlowers++;
                        }
                    }
                    beeTerritory[beeRow][beeCol] = 'B';
                    break;
                case "right":
                    beeCol++;
                    if (beeOutOfBound(beeCol , sizeSquareMatrix)){
                        beeLost  = true;
                        break;
                    }
                    symbol = beeTerritory[beeRow][beeCol];
                    if (symbol == 'f'){
                        countPollinateFlowers++;
                    } else if (symbol == 'O'){
                        beeTerritory[beeRow][beeCol] = '.';
                        beeCol++;
                        if (beeOutOfBound(beeRow , sizeSquareMatrix)){
                            beeLost = true;
                            break;
                        }
                        symbol = beeTerritory[beeRow][beeCol];
                        if (symbol == 'f'){
                            countPollinateFlowers++;
                        }
                    }
                    beeTerritory[beeRow][beeCol] = 'B';
                    break;
            }
            if (beeLost){
                break;
            }
            input = scanner.nextLine();
        }

        if (beeLost){
            System.out.println("The bee got lost!");
        }
        if (countPollinateFlowers >= 5) {
            System.out.printf("Great job, the bee manage to pollinate %d flowers!%n", countPollinateFlowers);
        } else {
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more%n",
                    5 - countPollinateFlowers);
        }
        printMatrix(beeTerritory);
    }

    private static boolean beeOutOfBound(int index , int matrixSize) {
        return index < 0 || index >= matrixSize;
    }

    private static void printMatrix(char[][] beeTerritory) {
        for (char[] chars : beeTerritory) {
            System.out.println(Arrays.toString(chars).replaceAll("[\\[\\], ]", ""));
        }
    }
}
