package Vehicles;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] carData = scanner.nextLine().split(" ");
        double fuelQuantity = Double.parseDouble(carData[1]);
        double fuelConsumption = Double.parseDouble(carData[2]);
        Car car = new Car(fuelQuantity , fuelConsumption);

        String[] truckData = scanner.nextLine().split(" ");
        fuelQuantity = Double.parseDouble(truckData[1]);
        fuelConsumption = Double.parseDouble(truckData[2]);
        Truck truck = new Truck(fuelQuantity , fuelConsumption);

        int count = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < count; i++) {
            String[] tokens = scanner.nextLine().split(" ");
            if (tokens[0].equals("Drive")){
                double distance = Double.parseDouble(tokens[2]);
                if (tokens[1].equals("Car")){
                    car.driving(distance);
                } else {
                    truck.driving(distance);
                }
            } else {
                double fuel = Double.parseDouble(tokens[2]);
                if (tokens[1].equals("Car")){
                    car.refueling(fuel);
                } else {
                    truck.refueling(fuel);
                }
            }
        }
        System.out.printf("Car: %.2f%n", car.getFuelQuantity());
        System.out.printf("Truck: %.2f", truck.getFuelQuantity());
    }
}
