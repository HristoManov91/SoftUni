package Exercise_05_ComparingObjects;

import org.w3c.dom.ls.LSOutput;

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
            personList.add(new Person(tokens[0] , Integer.parseInt(tokens[1]) , tokens[2]));
            input = scanner.nextLine();
        }

        int indexForPerson = Integer.parseInt(scanner.nextLine());
        int countEqualPeople = 0;
        for (Person person : personList) {
            if (personList.get(indexForPerson - 1).compareTo(person) == 0){
                countEqualPeople++;
            }
        }
        System.out.println(countEqualPeople == 1 ? "No matches" : String.format("%d %d %d",
                countEqualPeople, personList.size() - countEqualPeople, personList.size()));
    }
}
