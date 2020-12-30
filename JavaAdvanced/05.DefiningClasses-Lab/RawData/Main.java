package RawData;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int carCount = Integer.parseInt(scanner.nextLine());

        List<Car> carList = new LinkedList<>();
        for (int i = 0; i < carCount; i++) {
            String[] carData = scanner.nextLine().split(" ");
            //"<Model> <EngineSpeed> <EnginePower> <CargoWeight> <CargoType>
            // <Tire1Pressure> <Tire1Age> <Tire2Pressure> <Tire2Age> <Tire3Pressure> <Tire3Age> <Tire4Pressure> <Tire4Age>
            String carModel = carData[0];

            int engineSpeed = Integer.parseInt(carData[1]);
            int enginePower = Integer.parseInt(carData[2]);
            Engine engine = new Engine(engineSpeed , enginePower);

            int cargoWeight = Integer.parseInt(carData[3]);
            String cargoType = carData[4];
            Cargo cargo = new Cargo(cargoWeight , cargoType);

            Map<Double , Integer> tireInfo = new LinkedHashMap<>();
            for (int j = 5; j < carData.length; j+=2) {
                double tirePressure = Double.parseDouble(carData[j]);
                int tireAge = Integer.parseInt(carData[j+1]);
                tireInfo.put(tirePressure , tireAge);
            }
            Tire tires = new Tire(tireInfo);

            Car car = new Car(carModel , engine , cargo , tires);
            carList.add(car);
        }
        String command = scanner.nextLine();
        if (command.equals("fragile")){
            carList.stream()
                    .filter(car -> car.getCargo().getType().equals(command) && car.getTireInfo().averagePressure() < 1.0)
                    .forEach(car -> System.out.println(car.getModel()));
        } else if (command.equals("flamable")){
            carList.stream()
                    .filter(c -> c.getCargo().getType().equals(command) && c.getEngine().getEnginePower() > 250)
                    .forEach(c -> System.out.println(c.getModel()));
        }
    }
}
