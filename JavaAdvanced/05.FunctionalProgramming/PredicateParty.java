import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PredicateParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> people = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());

        String input = scanner.nextLine();
        while (!input.equals("Party!")){
            String[] tokens = input.split(" ");
            String command = tokens[0];
            switch (command){
                case "Remove":
                    break;
                case "Double":
                    break;
            }
            input = scanner.nextLine();
        }
    }
}
