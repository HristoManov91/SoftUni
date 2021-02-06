package Exercise_04_RawData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());

        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            String[] tokens = scanner.nextLine().split(" ");
            String model = tokens[0];
            int engineSpeed = Integer.parseInt(tokens[1]);
            int enginePower = Integer.parseInt(tokens[2]);
            Engine engine = new Engine(engineSpeed , enginePower);
            int cargoWeight = Integer.parseInt(tokens[3]);
            String cargoType = tokens[4];
            Cargo cargo = new Cargo(cargoWeight , cargoType);
            List<Tire> tires = new ArrayList<>();
            for (int j = 5; j < tokens.length; j+=2) {
                double tirePressure = Double.parseDouble(tokens[j]);
                int tireAge = Integer.parseInt(tokens[j + 1]);
                Tire tire = new Tire(tirePressure , tireAge);
                tires.add(tire);
            }
            Car car = new Car(model , engine , cargo , tires);
            carList.add(car);
        }
        String command = scanner.nextLine();
        switch (command){
            case "fragile":
                carList.stream()
                        .filter(c -> c.getCargo().getCargoType().equals("fragile"))
                        .filter(c -> c.getAveragePressure() < 1)
                        .forEach(c -> System.out.println(c.getModel()));
                break;
            case "flamable":
                carList.stream()
                        .filter(c -> c.getEngine().getPower() > 250)
                        .forEach(c -> System.out.println(c.getModel()));
                break;
        }
    }


}
