import java.util.Scanner;

public class ParkingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] dimensionsOfMatrix = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(dimensionsOfMatrix[0]);
        int cols = Integer.parseInt(dimensionsOfMatrix[1]);

        boolean[][] matrix = new boolean[rows][cols];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][0] = true;
        }
        String input = scanner.nextLine();
        while (!input.equals("stop")) {
            String[] tokens = input.split(" ");
            int entryRow = Integer.parseInt(tokens[0]);
            int coordinatesRow = Integer.parseInt(tokens[1]);
            int coordinatesCol = Integer.parseInt(tokens[2]);
            int distance = 0;
            if (!matrix[coordinatesRow][coordinatesCol]) {
                matrix[coordinatesRow][coordinatesCol] = true;
                distance = Math.abs(coordinatesRow - entryRow) + coordinatesCol + 1;
                System.out.println(distance);
            } else {
                if (rowHaveFreeSpot(matrix, coordinatesRow)) {
                    boolean findSpot = false;
                    int count = 1;
                    while (!findSpot) {
                        if (coordinatesCol - count > 0) {
                            if (!matrix[coordinatesRow][coordinatesCol - count]) {
                                matrix[coordinatesRow][coordinatesCol - count] = true;
                                findSpot = true;
                                coordinatesCol -= count;
                            }
                        }
                        if (coordinatesCol + count < matrix[coordinatesRow].length) {
                            if (!matrix[coordinatesRow][coordinatesCol + count]) {
                                matrix[coordinatesRow][coordinatesCol + count] = true;
                                findSpot = true;
                                coordinatesCol += count;
                            }
                        }
                        if (findSpot){
                            distance = Math.abs(coordinatesRow - entryRow) + coordinatesCol + 1;
                            System.out.println(distance);
                        } else {
                            count++;
                        }
                    }
                } else {
                    System.out.printf("Row %d full%n", coordinatesRow);
                }
            }
            input = scanner.nextLine();
        }
    }

    private static boolean rowHaveFreeSpot(boolean[][] matrix, int coordinatesRow) {
        for (boolean spot : matrix[coordinatesRow]) {
            if (!spot) {
                return true;
            }
        }
        return false;
    }
}
