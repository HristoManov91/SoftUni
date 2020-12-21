import java.util.Scanner;

public class TheHeiganDance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double hpHeigan = 3000000;
        double damageForHeigan = Double.parseDouble(scanner.nextLine());
        int playerHP = 18500;
        String lastSpell = "";

        int playerRow = 7;
        int playerCol = 7;

        int[][] matrix = new int[15][15];
        int damage;
        while (playerHP >= 0) {
            hpHeigan -= damageForHeigan;
            if (lastSpell.equals("Cloud")) {
                playerHP -= 3500;
            }
            if (hpHeigan <= 0) {
                System.out.println("Heigan: Defeated!");
                System.out.printf("Player: %d%n", playerHP);
                System.out.printf("Final position: %d, %d", playerRow, playerCol);
                break;
            }
            String[] command = scanner.nextLine().split("\\s+");
            String currentSpell = command[0];
            int targetRow = Integer.parseInt(command[1]);
            int targetCol = Integer.parseInt(command[2]);
            if (isInDamageArea(targetRow, targetCol, playerRow, playerCol)) {
                if (!isInDamageArea(targetRow, targetCol, playerRow - 1, playerCol) && !isWall(playerRow - 1)) {
                    playerRow--;
                }
                else if (!isInDamageArea(targetRow, targetCol, playerRow, playerCol + 1) && !isWall(playerCol + 1)){
                    playerCol++;
                }
                else if (!isInDamageArea(targetRow , targetCol , playerRow + 1 , playerCol) && !isWall(playerRow + 1)){
                    playerRow++;
                }
                else if (!isInDamageArea(targetRow , targetCol , playerRow , playerCol - 1) && !isWall(playerCol - 1)){
                    playerCol--;
                }
                else {
                    if (currentSpell.equals("Cloud")){
                        playerHP -= 3500;
                        lastSpell = "Cloud";
                    }
                    else if (currentSpell.equals("Eruption")){
                        playerHP -= 6000;
                        lastSpell = "Eruption";
                    }
                }
            }
        }
        if (playerHP <= 0){
            System.out.printf("Heigan: %.2f%n", hpHeigan);
            System.out.printf("Player: Killed by %s%n", lastSpell);
            System.out.printf("Final position: %d, %d", playerRow , playerCol);
        }
    }

    private static boolean isWall(int moveCell) {
        return moveCell < 0 || moveCell >= 15;
    }

    private static boolean isInDamageArea(int targetRow, int targetCol, int moveRow, int moveCol) {
        return ((targetRow - 1 <= moveRow && moveRow <= targetRow + 1)
                && (targetCol - 1 <= moveCol && moveCol <= targetCol + 1));
    }
}
