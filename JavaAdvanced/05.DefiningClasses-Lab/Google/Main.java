package Google;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Person> personList = new ArrayList<>();

        String command = scanner.nextLine();
        while (!command.equals("End")){
            String[] tokens = command.split(" ");
            String personName = tokens[0];
            boolean havePerson = false;
            for (Person person : personList) {
                if (person.getNamePerson().equals(personName)){
                    havePerson = true;
                    break;
                }
            }
            if (!havePerson){
                Person person = new Person();
                person.setNamePerson(personName);
                personList.add(person);
            }
            Person person = searchPerson(personList , personName);
            switch (tokens[1]){
                case "company":
                    String companyName = tokens[2];
                    String department = tokens[3];
                    double salary = Double.parseDouble(tokens[4]);
                    Company company = new Company(companyName , department , salary);
                    person.setCompany(company);
                    break;
                case "pokemon":
                    String pokemonName = tokens[2];
                    String pokemonType = tokens[3];
                    Pokemon pokemon = new Pokemon(pokemonName , pokemonType);
                    person.getPokemon().add(pokemon);
                    break;
                case "parents":
                    String parentsName = tokens[2];
                    String parentsBirthday = tokens[3];
                    Parents parents = new Parents(parentsName , parentsBirthday);
                    person.getParents().add(parents);
                    break;
                case "children":
                    String childName = tokens[2];
                    String childBirthday = tokens[3];
                    Children children = new Children(childName , childBirthday);
                    person.getChildren().add(children);
                    break;
                case "car":
                    String carModel = tokens[2];
                    String carSpeed = tokens[3];
                    Car car = new Car(carModel , carSpeed);
                    person.setCar(car);
                    break;
            }
            command = scanner.nextLine();
        }
        String name = scanner.nextLine();
        Person personToPrint = searchPerson(personList , name);

        printPersonInfo(personToPrint);
    }

    private static void printPersonInfo(Person personToPrint) {
        System.out.println(personToPrint.getNamePerson());
        System.out.println("Company:");
        if (personToPrint.getCompany() != null){
            System.out.printf("%s %s %.2f%n" , personToPrint.getCompany().getCompanyName() ,
                    personToPrint.getCompany().getDepartment() , personToPrint.getCompany().getSalary());
        }
        System.out.println("Car:");
        if (personToPrint.getCar() != null){
            System.out.println(personToPrint.getCar().getCarModel() + " " + personToPrint.getCar().getCarSpeed());
        }
        System.out.println("Pokemon:");
        if (personToPrint.getPokemon().size() > 0){
            personToPrint.getPokemon().forEach(p -> System.out.println(p.getPokemonName() + " " + p.getPokemonType()));
        }
        System.out.println("Parents:");
        if (personToPrint.getParents().size() > 0){
            personToPrint.getParents().forEach(p -> System.out.println(p.getParents() + " " + p.getParentsBirthday()));
        }
        System.out.println("Children:");
        if (personToPrint.getChildren().size() > 0){
            personToPrint.getChildren().forEach(c -> System.out.println(c.getChildren() + " " + c.getChildBirthday()));
        }
    }

    private static Person searchPerson(List<Person> personList, String personName) {
        Person searchPerson = null;
        for (Person person : personList) {
            if (person.getNamePerson().equals(personName)){
                searchPerson = person;
                break;
            }
        }
        return searchPerson;
    }
}
