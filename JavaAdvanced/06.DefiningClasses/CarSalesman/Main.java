package CarSalesman;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Engine> engineList = new ArrayList<>();
        
        int countEngine = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < countEngine; i++) {
            String[] tokens = scanner.nextLine().split(" ");
            String model = tokens[0];
            int power = Integer.parseInt(tokens[1]);

            if (tokens.length == 2){
                Engine engine = new Engine(model , power);
                engineList.add(engine);
            } else if (tokens.length == 3){
                if (Character.isDigit(tokens[2].charAt(0))){
                    int displacement = Integer.parseInt(tokens[2]);
                    Engine engine = new Engine(model , power , displacement);
                    engineList.add(engine);
                } else {
                    String efficiency = tokens[2];
                    Engine engine = new Engine(model , power , efficiency);
                    engineList.add(engine);
                }
            } else if (tokens.length == 4){
                int displacement = Integer.parseInt(tokens[2]);
                String efficiency = tokens[3];
                Engine engine = new Engine(model , power , displacement , efficiency);
                engineList.add(engine);
            }
        }
        List<Car> carList = new ArrayList<>();
        int countCars = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < countCars; i++) {
            String[] tokens = scanner.nextLine().split(" ");
            String carModel = tokens[0];
            Engine engine = null;
            for (Engine eng : engineList) {
                if (eng.getEngineModel().equals(tokens[1])){
                    engine = eng;
                    break;
                }
            }
            if (tokens.length == 2){
                Car car = new Car(carModel , engine);
                carList.add(car);
            } else if (tokens.length == 3){
                if (Character.isDigit(tokens[2].charAt(0))){
                    int weight = Integer.parseInt(tokens[2]);
                    Car car = new Car(carModel , engine , weight);
                    carList.add(car);
                } else {
                    String color = tokens[2];
                    Car car = new Car(carModel , engine , color);
                    carList.add(car);
                }
            } else if (tokens.length == 4){
                int weight = Integer.parseInt(tokens[2]);
                String color = tokens[3];

                Car car = new Car(carModel , engine , weight , color);
                carList.add(car);
            }
        }
        carList.forEach(car -> System.out.print(car.toString()));
    }
}
