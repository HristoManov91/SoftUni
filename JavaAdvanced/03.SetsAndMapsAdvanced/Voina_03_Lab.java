import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Voina_03_Lab {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<Integer> playerOneDeck = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).boxed().collect(Collectors.toCollection(LinkedHashSet::new));

        Set<Integer> playerTwoDeck = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).boxed().collect(Collectors.toCollection(LinkedHashSet::new));

        int round = 1;
        while (round <= 50 && !playerOneDeck.isEmpty() && !playerTwoDeck.isEmpty()){
            int playerOneCard = playerOneDeck.iterator().next();
            playerOneDeck.remove(playerOneCard);
            int playerTwoCard = playerTwoDeck.iterator().next();
            playerTwoDeck.remove(playerTwoCard);

            if (playerOneCard > playerTwoCard){
                playerOneDeck.add(playerOneCard);
                playerOneDeck.add(playerTwoCard);
            } else if (playerTwoCard > playerOneCard){
                playerTwoDeck.add(playerOneCard);
                playerTwoDeck.add(playerTwoCard);
            }
            round++;
        }
        if (playerOneDeck.size() < playerTwoDeck.size()){
            System.out.println("Second player win!");
        } else if (playerOneDeck.size() > playerTwoDeck.size()){
            System.out.println("First player win!");
        } else {
            System.out.println("Draw!");
        }
    }
}
