package SpeedRacing;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        Map<String , Car> cars = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            String model = input[0];
            double fuel = Double.parseDouble(input[1]);
            double consumption = Double.parseDouble(input[2]);

            Car car = new Car(model , fuel , consumption);
            cars.put(model , car);
        }

        String input = scanner.nextLine();
        while (!input.equals("End")){
            String model = input.split("\\s+")[1];
            int distanceToDrive = Integer.parseInt(input.split("\\s+")[2]);

            Car carToDrive = cars.get(model);
            if (!carToDrive.drive(distanceToDrive)){
                System.out.println("Insufficient fuel for the drive");
            }
            input = scanner.nextLine();
        }
        for (Car car : cars.values()) {
            System.out.println(car.toString());
        }
    }
}
