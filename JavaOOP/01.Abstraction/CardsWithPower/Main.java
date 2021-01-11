package CardsWithPower;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String card = scanner.nextLine();
        String suit = scanner.nextLine();

        System.out.printf("Card name: %s of %s; Card power: %d", card , suit , powerOfCard(card , suit));
    }

    public static int powerOfCard(String card , String suit){
        return CardDeck.valueOf(card).getValue() + SuitsPower.valueOf(suit).getValue();
    }
}
