import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TheHeiganDnace_08_Exercise {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int hpPlayer = 18500;
        double hpHeigan = 3000000;
        double playerDamage = Double.parseDouble(scanner.nextLine());

        int playerRowPosition = 7;
        int playerColPosition = 7;

        String lastSpell = "";
        int remainsDamage = 0;
        while (hpHeigan > 0 && hpPlayer > 0) {
            hpHeigan -= playerDamage;
            if (hpHeigan <= 0) {
                break;
            }
            if (remainsDamage > 0) {
                hpPlayer -= remainsDamage;
                if (hpPlayer < 1) {
                    break;
                }
                remainsDamage = 0;
            }
            String[] tokens = scanner.nextLine().split("\\s+");
            String magic = tokens[0];
            lastSpell = magic;
            int damage = 0;
            if (magic.equals("Cloud")) {
                remainsDamage += 3500;
                damage = 3500;
            } else if (magic.equals("Eruption")) {
                damage = 6000;
            }
            int rowToMagicAttack = Integer.parseInt(tokens[1]);
            int colToMagicAttack = Integer.parseInt(tokens[2]);

            boolean[][] matrix = new boolean[15][15];
            for (int r = rowToMagicAttack - 1; r <= rowToMagicAttack + 1; r++) {
                if (r >= 0 && r < matrix.length) {
                    for (int c = colToMagicAttack - 1; c <= colToMagicAttack + 1; c++) {
                        if (c >= 0 && c < matrix[rowToMagicAttack].length) {
                            matrix[r][c] = true;
                        }
                    }
                }
            }
            if (matrix[playerRowPosition][playerColPosition]) {
                if (isRowValid(matrix, playerRowPosition - 1)
                        && !matrix[playerRowPosition - 1][playerColPosition]) {
                    playerRowPosition--; // move up
                } else if (isColValid(matrix, playerColPosition + 1)
                        && !matrix[playerRowPosition][playerColPosition + 1]) {
                    playerColPosition++; // move right
                } else if (isRowValid(matrix, playerRowPosition + 1)
                        && !matrix[playerRowPosition + 1][playerColPosition]) {
                    playerRowPosition++; // move down
                } else if (isColValid(matrix, playerColPosition - 1)
                        && !matrix[playerRowPosition][playerColPosition - 1]) {
                    playerColPosition--; // move left
                }

                if (matrix[playerRowPosition][playerColPosition]){
                    hpPlayer -= damage;
                } else {
                    remainsDamage = 0;
                }
            }
        }
        if (hpHeigan > 0) {
            System.out.printf("Heigan: %.2f%n", hpHeigan);
        } else {
            System.out.println("Heigan: Defeated!");
        }
        if (hpPlayer > 0) {
            System.out.printf("Player: %d%n", hpPlayer);
        } else {
            if (lastSpell.equals("Cloud")){
                lastSpell = "Plague Cloud";
            }
            System.out.println("Player: Killed by " + lastSpell);
        }

        System.out.println("Final position: " + playerRowPosition + ", " + playerColPosition);
    }

    private static boolean isRowValid(boolean[][] matrix, int startPlRow) {
        return startPlRow >= 0 && startPlRow < matrix[startPlRow].length;
    }

    private static boolean isColValid(boolean[][] matrix, int startPlCol) {
        return startPlCol >= 0 && startPlCol < matrix.length;
    }
}