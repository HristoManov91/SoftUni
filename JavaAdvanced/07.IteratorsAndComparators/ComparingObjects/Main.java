package ComparingObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Person> personList = new ArrayList<>();

        String input = scanner.nextLine();
        while (!input.equals("END")){
            String[] tokens = input.split(" ");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);
            String town = tokens[2];

            Person person = new Person(name , age , town);
            personList.add(person);

            input = scanner.nextLine();
        }
        int indexPerson = Integer.parseInt(scanner.nextLine()) - 1;
        Person personForCompare = personList.get(indexPerson);
        personList.remove(indexPerson);

        int countEqual = 0;
        int notEqualPeople = 0;

        for (Person person : personList) {
            if (personForCompare.compareTo(person) == 0){
                countEqual++;
            } else {
                notEqualPeople++;
            }
        }
        if (countEqual == 0){
            System.out.println("No matches");
        } else {
            System.out.println(++countEqual + " " + notEqualPeople + " " + (personList.size() + 1));
        }
    }
}
