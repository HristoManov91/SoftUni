package VehiclesExtension;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String , Vehicle> vehicleMap = new LinkedHashMap<>();

        String[] tokens = scanner.nextLine().split(" ");
        vehicleMap.put("Car" , new Car(Double.parseDouble(tokens[1]) , Double.parseDouble(tokens[2]) ,
                Double.parseDouble(tokens[3])));

        tokens = scanner.nextLine().split(" ");
        vehicleMap.put("Truck" , new Truck(Double.parseDouble(tokens[1]) , Double.parseDouble(tokens[2]) ,
                Double.parseDouble(tokens[3])));

        tokens = scanner.nextLine().split(" ");
        vehicleMap.put("Bus" , new Bus(Double.parseDouble(tokens[1]) , Double.parseDouble(tokens[2]) ,
                Double.parseDouble(tokens[3])));

        int count = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < count; i++) {
            String[] command = scanner.nextLine().split(" ");
            double argument = Double.parseDouble(command[2]);

            if ("Refuel".equals(command[0])) {
                vehicleMap.get(command[1]).refueling(argument);
            } else if (command[0].equals("Drive") && command[1].equals("Bus")) {
                vehicleMap.get(command[1]).setFuelConsumption(vehicleMap.get(command[1]).getFuelConsumption() + 1.4);
                vehicleMap.get(command[1]).driving(argument);
                vehicleMap.get(command[1]).setFuelConsumption(vehicleMap.get(command[1]).getFuelConsumption() - 1.4);
            } else {
                vehicleMap.get(command[1]).driving(argument);
            }
        }

        for (Vehicle vehicle : vehicleMap.values()) {
            System.out.printf("%s: %.2f%n", vehicle.getClass().getSimpleName() , vehicle.getFuelQuantity());
        }
    }
}
