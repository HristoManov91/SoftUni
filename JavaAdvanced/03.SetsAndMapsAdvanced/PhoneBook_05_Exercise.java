import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PhoneBook_05_Exercise {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String , String> phonebook = new HashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("search")){
            String[] tokens = input.split("-");
            phonebook.put(tokens[0] , tokens[1]);

            input = scanner.nextLine();
        }

        input = scanner.nextLine();
        while (!input.equals("stop")){
            if (phonebook.containsKey(input)){
                System.out.println(input + " -> " + phonebook.get(input));
            } else {
                System.out.printf("Contact %s does not exist.%n", input);
            }

            input = scanner.nextLine();
        }
    }
}
