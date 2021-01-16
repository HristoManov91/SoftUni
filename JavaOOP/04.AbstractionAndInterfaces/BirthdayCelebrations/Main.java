package BirthdayCelebrations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        List<Birthable> birthableList = new ArrayList<>();

        while (!input.equals("End")){
            String[] tokens = input.split(" ");
            switch (tokens[0]){
                case "Citizen":
                    Citizen citizen = new Citizen(tokens[1] , Integer.parseInt(tokens[2]) , tokens[3] , tokens[4]);
                    birthableList.add(citizen);
                    break;
                case "Robot":
                    Robot robot = new Robot(tokens[1] , tokens[2]);
                    break;
                case "Pet":
                    Pet pet = new Pet(tokens[1] , tokens[2]);
                    birthableList.add(pet);
                    break;
            }
            input = scanner.nextLine();
        }

        String specificYear = scanner.nextLine();

        for (Birthable birthable : birthableList) {
            if (birthable.getBirthDate().endsWith(specificYear)){
                System.out.println(birthable.getBirthDate());
            }
        }
    }
}
