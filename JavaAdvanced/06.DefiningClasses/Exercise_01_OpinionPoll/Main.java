package Exercise_01_OpinionPoll;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());

        List<Person> personList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            String[] tokens = scanner.nextLine().split(" ");
            personList.add(new Person(tokens[0] , Integer.parseInt(tokens[1])));
        }

        personList.stream()
                .filter(p -> p.getAge() > 30)
                .sorted(Comparator.comparing(Person::getName))
                .forEach(p -> System.out.println(p.getName() + " - " + p.getAge()));
    }
}
