package Exercise_03_WildFarm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Animal> animalList = new ArrayList<>();

        String input = scanner.nextLine();
        while (!input.equals("End")) {
            //{AnimalType} {AnimalName} {AnimalWeight} {AnimalLivingRegion} [{CatBreed} = Only if its cat]
            String[] animalTokens = input.split("\\s+");
            Animal animal = createAnimal(animalTokens);

            animal.makeSound();

            String[] foodTokens = scanner.nextLine().split("\\s+");
            Food food = createFood(foodTokens);

            try {
                animal.eat(food);
            } catch (IllegalArgumentException ex){
                System.out.println(ex.getMessage());
            }

            animalList.add(animal);

            input = scanner.nextLine();
        }

        animalList.forEach(System.out::println);
    }

    private static Food createFood(String[] foodTokens) {
        int quantity = Integer.parseInt(foodTokens[1]);
        return foodTokens[0].equals("Meat") ? new Meat(quantity) : new Vegetable(quantity);
    }

    private static Animal createAnimal(String[] animalTokens) {
        switch (animalTokens[0]){
            case "Cat":
                return new Cat(animalTokens[1] , "Cat" , Double.parseDouble(animalTokens[2]) ,
                        animalTokens[3] , animalTokens[4]);
            case "Tiger":
                return new Tiger(animalTokens[1], "Tiger" , Double.parseDouble(animalTokens[2]) ,
                        animalTokens[3]);
            case "Zebra":
                return new Zebra(animalTokens[1] , "Zebra" , Double.parseDouble(animalTokens[2]) ,
                        animalTokens[3]);
            case "Mouse":
                return new Mouse(animalTokens[1], "Mouse" , Double.parseDouble(animalTokens[2]) ,
                        animalTokens[3]);
            default:
                throw new IllegalStateException("Unknown animal type " + animalTokens[0]);
        }
    }
}
