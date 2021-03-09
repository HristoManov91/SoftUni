package Exercise_04_FoodShortage;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());

        Set<Person> people = new LinkedHashSet<>();
        for (int i = 0; i < count; i++) {
            String[] tokens = scanner.nextLine().split(" ");

            if (tokens.length == 4) {
                people.add(new Citizen(tokens[0], Integer.parseInt(tokens[1]), tokens[2], tokens[3]));
            } else if (tokens.length == 3) {
                people.add(new Rebel(tokens[0], Integer.parseInt(tokens[1]), tokens[2]));
            }
        }

        String command = scanner.nextLine();
        while (!command.equals("End")) {
            for (Person person : people) {
                if (person.getName().equals(command)) {
                    person.buyFood();
                }
            }
            command = scanner.nextLine();
        }
        System.out.println(people.stream().mapToInt(Buyer::getFood).sum());
    }
}
