import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HouseParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> guestsToParty = new ArrayList<>();
        int countCommand = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < countCommand; i++) {
            String[] input = scanner.nextLine().split(" is ");
            String name = input[0];
            String command = input[1];
            switch (command) {
                case "going!":
                    if (guestsToParty.contains(name)){
                        System.out.printf("%s is already in the list!%n", name);
                    } else {
                        guestsToParty.add(name);
                    }
                    break;
                default:
                    if (guestsToParty.contains(name)){
                        guestsToParty.remove(name);
                    } else {
                        System.out.printf("%s is not in the list!%n", name);
                    }
                    break;
            }
        }
        for (String name : guestsToParty) {
            System.out.println(name);
        }
    }
}
