import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class MagicCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> cardsDeck = Arrays.stream(scanner.nextLine().split(":")).collect(Collectors.toList());

        List<String> newCardsDeck = new ArrayList<>();
        String input = scanner.nextLine();
        while (!input.equals("Ready")){
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            switch (command){
                case "Add":
                    String cardToAdd = tokens[1];
                    if (cardsDeck.contains(cardToAdd)){
                        newCardsDeck.add(cardToAdd);
                    } else {
                        System.out.println("Card not found.");
                    }
                    break;
                case "Insert":
                    String cardName = tokens[1];
                    int indexToAdd = Integer.parseInt(tokens[2]);
                    if (cardsDeck.contains(cardName) && 0 <= indexToAdd && indexToAdd < newCardsDeck.size()){
                        newCardsDeck.add(indexToAdd , cardName);
                    } else {
                        System.out.println("Error!");
                    }
                    break;
                case "Remove":
                    String cardToRemove = tokens[1];
                    if (newCardsDeck.contains(cardToRemove)){
                        newCardsDeck.remove(cardToRemove);
                    } else {
                        System.out.println("Card not found.");
                    }
                    break;
                case "Swap":
                    String firstCardName = tokens[1];
                    String secondCardName = tokens[2];
                    int indexFirstCard = newCardsDeck.indexOf(firstCardName);
                    int indexSecondCard = newCardsDeck.indexOf(secondCardName);
                    newCardsDeck.set(indexFirstCard , secondCardName);
                    newCardsDeck.set(indexSecondCard , firstCardName);
                    break;
                case "Shuffle":
                    Collections.reverse(newCardsDeck);
                    break;
            }
            input = scanner.nextLine();
        }
        for (String card : newCardsDeck) {
            System.out.print(card + " ");
        }
    }
}
