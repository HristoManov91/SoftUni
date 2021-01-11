package CardRank;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(scanner.nextLine() + ":");

        for (CardRank card : CardRank.values()) {
            System.out.println(card.toString());
        }
    }
}
