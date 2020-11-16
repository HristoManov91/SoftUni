import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Inventory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> inventory = Arrays.stream(scanner.nextLine().split(", "))
                .collect(Collectors.toList());

        String input = scanner.nextLine();
        while (!input.equals("Craft!")){
            String[] tokens = input.split(" - ");
            String command = tokens[0];
            switch (command){
                case "Collect":
                    String itemToAdd = tokens[1];
                    if (!inventory.contains(itemToAdd)){
                        inventory.add(itemToAdd);
                    }
                    break;
                case "Drop":
                    String itemToDrop = tokens[1];
                    inventory.remove(itemToDrop);
                    break;
                case "Combine Items":
                    String[] items = tokens[1].split(":");
                    String oldItem = items[0];
                    String newItem = items[1];
                    int index = inventory.indexOf(oldItem);
                    if (index != -1){
                        inventory.add(index + 1, newItem);
                    }
                    break;
                case "Renew":
                    String itemToChange = tokens[1];
                    if (inventory.contains(itemToChange)){
                        inventory.add(itemToChange);
                        inventory.remove(itemToChange);
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.println(inventory.toString().replaceAll("[\\[\\]]", ""));
    }
}
