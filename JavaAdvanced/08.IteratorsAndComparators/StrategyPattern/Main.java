package StrategyPattern;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        Set<Person> compareByName = new TreeSet<>(new PersonNameComparator());
        Set<Person> compareByAge = new TreeSet<>(new PersonAgeComparator());
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split(" ");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);

            Person person = new Person(name , age);
            compareByName.add(person);
            compareByAge.add(person);
        }

        compareByName.forEach(System.out::println);
        compareByAge.forEach(System.out::println);
    }
}
