package Exercise_06_StrategyPatern;

import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());

        TreeSet<Person> personByName = new TreeSet<>(new PersonNameComparator());
        TreeSet<Person> personByAge = new TreeSet<>(new PersonAgeComparator());
        for (int i = 0; i < count; i++) {
            String[] tokens = scanner.nextLine().split(" ");
            Person person = new Person(tokens[0] , Integer.parseInt(tokens[1]));
            personByName.add(person);
            personByAge.add(person);
        }

        personByName.forEach(p -> System.out.println(p.getName() + " " + p.getAge()));
        personByAge.forEach(p -> System.out.println(p.getName() + " " + p.getAge()));
    }
}
