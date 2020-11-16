import java.util.Scanner;

public class MuOnline {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int health = 100;
        int bitcoins = 0;

        String[] rooms = scanner.nextLine().split("\\|");
        for (int i = 0; i < rooms.length; i++) {
            String[] tokens = rooms[i].split(" ");
            switch (tokens[0]) {
                case "potion":
                    int potionToHeal = Integer.parseInt(tokens[1]);
                    if (potionToHeal + health > 100) {
                        int healingPoint = 100 - health;
                        health = 100;
                        System.out.printf("You healed for %d hp.%n", healingPoint);
                        System.out.printf("Current health: %d hp.%n", health);
                    } else {
                        health += potionToHeal;
                        System.out.printf("You healed for %d hp.%n", potionToHeal);
                        System.out.printf("Current health: %d hp.%n", health);
                    }
                    break;
                case "chest":
                    int foundedBitcoins = Integer.parseInt(tokens[1]);
                    bitcoins += foundedBitcoins;
                    System.out.printf("You found %d bitcoins.%n", foundedBitcoins);
                    break;
                default:
                    String monster = tokens[0];
                    int powerOfMonster = Integer.parseInt(tokens[1]);
                    health -= powerOfMonster;
                    if (health > 0) {
                        System.out.printf("You slayed %s.%n", monster);
                    } else {
                        System.out.printf("You died! Killed by %s.%n", monster);
                        System.out.printf("Best room: %d%n", i + 1);
                        return;
                    }
                    break;
            }
        }
        System.out.printf("You've made it!%n" +
                "Bitcoins: %d%n" +
                "Health: %d", bitcoins, health);
    }
}
