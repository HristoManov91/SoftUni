package Animals;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.DoubleAccumulator;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String typeAnimal = scanner.nextLine();
        while (!typeAnimal.equals("Beast!")){
            String[] data = scanner.nextLine().split(" ");
            String name = data[0];
            int age = Integer.parseInt(data[1]);
            if ( age <= 0){
                System.out.println("Invalid input!");
                typeAnimal = scanner.nextLine();
                continue;
            }
            String gender = data[2];

            switch (typeAnimal){
                case "Dog":
                    Dog dog = new Dog(name , age , gender);
                    System.out.println(dog.toString());
                    break;
                case "Cat":
                    Cat cat = new Cat(name , age , gender);
                    System.out.println(cat.toString());
                    break;
                case "Frog":
                    Frog frog = new Frog(name , age , gender);
                    System.out.println(frog.toString());
                    break;
                case "Kitten":
                    Kitten kitten = new Kitten(name , age , gender);
                    System.out.println(kitten.toString());
                    break;
                case "Tomcat":
                    Tomcat tomcat = new Tomcat(name , age , gender);
                    System.out.println(tomcat.toString());
                    break;
                default:
                    System.out.println("Invalid input!");
                    break;
            }
            typeAnimal = scanner.nextLine();
        }
    }
}
