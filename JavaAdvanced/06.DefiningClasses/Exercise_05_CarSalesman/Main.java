package Exercise_05_CarSalesman;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countEngine = Integer.parseInt(scanner.nextLine());

        List<Engine> engines = new ArrayList<>();
        for (int i = 0; i < countEngine; i++) {
            String[] tokens = scanner.nextLine().split(" ");
            String model = tokens[0];
            int power = Integer.parseInt(tokens[1]);
            if (tokens.length == 2){
                engines.add(new Engine(model , power));
            } else if (tokens.length == 3){
                try {
                    int displacement = Integer.parseInt(tokens[2]);
                    engines.add(new Engine(model , power , displacement));
                } catch (Exception e){
                    String efficiency = tokens[2];
                    engines.add(new Engine(model , power , efficiency));
                }
            } else if (tokens.length == 4){
                int displacement = Integer.parseInt(tokens[2]);
                String efficiency = tokens[3];
                engines.add(new Engine(model , power , displacement , efficiency));
            }
        }
        int countCars = Integer.parseInt(scanner.nextLine());
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < countCars; i++) {
            String[] tokens = scanner.nextLine().split(" ");
            String model = tokens[0];
            Engine engine = null;
            for (Engine eng : engines) {
                if (eng.getModel().equals(tokens[1])){
                    engine = eng;
                }
            }
            if (tokens.length == 2){
                carList.add(new Car(model , engine));
            } else if (tokens.length == 3){
                try {
                    int weight = Integer.parseInt(tokens[2]);
                    carList.add(new Car(model , engine , weight));
                } catch (Exception e){
                    carList.add(new Car(model , engine , tokens[2]));
                }
            } else if (tokens.length == 4){
                carList.add(new Car (model , engine , Integer.parseInt(tokens[2]) , tokens[3]));
            }
        }
        carList.forEach(c -> System.out.println(c.toString()));
    }
}
