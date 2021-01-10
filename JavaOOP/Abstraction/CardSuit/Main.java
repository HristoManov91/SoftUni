package CardSuit;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(scanner.nextLine() + ":");
        for (CardSuits value : CardSuits.values()) {
            System.out.println(value.toString());
        }
    }
}
