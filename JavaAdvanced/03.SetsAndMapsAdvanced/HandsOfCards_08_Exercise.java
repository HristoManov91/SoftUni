import java.util.*;

public class HandsOfCards_08_Exercise {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Set<String>> playersDecks = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("JOKER")) {
            String[] tokens = input.split(": ");
            String name = tokens[0];
            String[] cards = tokens[1].split(", ");
            playersDecks.putIfAbsent(name, new HashSet<>());
            playersDecks.get(name).addAll(Arrays.asList(cards));

            input = scanner.nextLine();
        }
        Map<String, Integer> playersPoints = new LinkedHashMap<>();
        for (Map.Entry<String, Set<String>> playerDeck : playersDecks.entrySet()) {
            int playerPoints = 0;
            Set<String> value = playerDeck.getValue();
            for (String card : value) {
                String num = "";
                String colour = "";
                char[] cardArr = card.toCharArray();
                for (int i = 0; i < cardArr.length; i++) {
                    if (Character.isDigit(cardArr[i])) {
                        num += cardArr[i];
                    } else if (cardArr[i] == 'J' || cardArr[i] == 'A' || cardArr[i] == 'Q' || cardArr[i] == 'K') {
                        switch (cardArr[i]) {
                            case 'J':
                                num = "11";
                                break;
                            case 'Q':
                                num = "12";
                                break;
                            case 'K':
                                num = "13";
                                break;
                            case 'A':
                                num = "14";
                                break;
                        }
                    } else if (cardArr[i] == 'S' || cardArr[i] == 'H' || cardArr[i] == 'D' || cardArr[i] == 'C') {
                        colour += cardArr[i];
                    }
                }
                switch (colour) {
                    case "S":
                        playerPoints += (4 * Integer.parseInt(num));
                        break;
                    case "H":
                        playerPoints += (3 * Integer.parseInt(num));
                        break;
                    case "D":
                        playerPoints += (2 * Integer.parseInt(num));
                        break;
                    case "C":
                        playerPoints += Integer.parseInt(num);
                        break;
                }
            }
            playersPoints.put(playerDeck.getKey(), playerPoints);
        }
        playersPoints.forEach((key, value) -> System.out.println(key + ": " + value));
    }
}
