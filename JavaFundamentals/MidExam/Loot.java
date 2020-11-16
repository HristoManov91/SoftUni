import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class Loot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> pirateTreasure = Arrays.stream(scanner.nextLine().split("\\|")).collect(Collectors.toList());

        String input = scanner.nextLine();
        while (!input.equals("Yohoho!")){
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            switch (command){
                case "Loot":
                    for (int i = 1; i < tokens.length; i++) {
                        String itemToAdd = tokens[i];
                        if (!pirateTreasure.contains(itemToAdd)){
                            pirateTreasure.add(0 , itemToAdd);
                        }
                    }
                    break;
                case "Drop":
                    int index = Integer.parseInt(tokens[1]);
                    if (0 <= index && index < pirateTreasure.size()){
                        String temp = pirateTreasure.get(index);
                        pirateTreasure.add(temp);
                        pirateTreasure.remove(index);
                    }
                    break;
                case "Steal":
                    int count = Integer.parseInt(tokens[1]);
                    List<String> stealItems = new ArrayList<>();
                    if (count < pirateTreasure.size()){
                        int addItems = 0;
                        for (int i = pirateTreasure.size() - 1; i >= pirateTreasure.size() - count; i--) {
                            stealItems.add(pirateTreasure.get(i));
                            pirateTreasure.remove(i);
                            addItems++;
                            if (addItems == count){
                                break;
                            }
                        }
                        Collections.reverse(stealItems);
                    } else {
                        stealItems.addAll(pirateTreasure);
                        pirateTreasure.removeAll(pirateTreasure);
                    }
                    System.out.println(stealItems.toString().replaceAll("[\\[\\]]", ""));
                    break;
            }
            input = scanner.nextLine();
        }
        if (pirateTreasure.size() > 0){
            int sumAllTreasureLength = 0;
            for (String item : pirateTreasure) {
                sumAllTreasureLength += item.length();
            }
            double averageTreasure = sumAllTreasureLength * 1.0 / pirateTreasure.size();
            System.out.printf("Average treasure gain: %.2f pirate credits.", averageTreasure);
        } else {
            System.out.println("Failed treasure hunt.");
        }
    }
}
