package Exercise_07_Google;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Person> personList = new ArrayList<>();

        String input = scanner.nextLine();
        while (!input.equals("End")){
            String[] tokens = input.split(" ");
            String name = tokens[0];
            boolean isContainsName = isContainsName(personList , name);
            if (!isContainsName){
                Person person = new Person(name);
                personList.add(person);
            }
            switch (tokens[1]){
                case "company":
                    Company company = new Company(tokens[2] , tokens[3] , Double.parseDouble(tokens[4]));
                    personList.get(indexOfPerson(personList , name)).setCompany(company);
                    break;
                case "pokemon":
                    Pokemon pokemon = new Pokemon(tokens[2] , tokens[3]);
                    personList.get(indexOfPerson(personList , name)).getPokemonList().add(pokemon);
                    break;
                case "parents":
                    Parents parents = new Parents(tokens[2] , tokens[3]);
                    personList.get(indexOfPerson(personList , name)).getParentsList().add(parents);
                    break;
                case "children":
                    Children children = new Children(tokens[2] , tokens[3]);
                    personList.get(indexOfPerson(personList, name)).getChildrenList().add(children);
                    break;
                case "car":
                    Car car = new Car(tokens[2] , tokens[3]);
                    personList.get(indexOfPerson(personList , name)).setCar(car);
                    break;
            }
            input = scanner.nextLine();
        }
        String personToPrint = scanner.nextLine();
        System.out.println(personList.get(indexOfPerson(personList , personToPrint)).toString());

    }

    private static boolean isContainsName (List<Person> personList, String name) {
        for (Person person : personList) {
            if (person.getName().equals(name)){
                return true;
            }
        }
        return false;
    }

    private static int indexOfPerson (List<Person> personList , String name){
        int index = -1;
        for (int i = 0; i < personList.size(); i++) {
            if (personList.get(i).getName().equals(name)){
                index = i;
                break;
            }
        }
        return index;
    }
}
