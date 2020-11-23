import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CardsGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> playerOneCards = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> playerTwoCards = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        while (!(playerOneCards.isEmpty() || playerTwoCards.isEmpty())){
            if (playerOneCards.get(0) > playerTwoCards.get(0)){
                playerOneCards.add(playerOneCards.get(0));
                playerOneCards.remove(0);
                playerOneCards.add(playerTwoCards.get(0));
                playerTwoCards.remove(0);
            } else if (playerOneCards.get(0) < playerTwoCards.get(0)){
                playerTwoCards.add(playerTwoCards.get(0));
                playerTwoCards.remove(0);
                playerTwoCards.add(playerOneCards.get(0));
                playerOneCards.remove(0);
            } else if (playerOneCards.get(0).equals(playerTwoCards.get(0))){
                playerOneCards.remove(0);
                playerTwoCards.remove(0);
            }
        }
        int sum = 0;
        if (playerTwoCards.isEmpty()){
            for (int num : playerOneCards) {
                sum += num;
            }
            System.out.printf("First player wins! Sum: %d", sum);
        } else {
            for (int num : playerTwoCards) {
                sum += num;
            }
            System.out.printf("Second player wins! Sum: %d", sum);
        }
    }
}
