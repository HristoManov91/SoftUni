package Exercise_03_SpeedRacing;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());
        Map<String , Car> cars = new LinkedHashMap<>();
        for (int i = 0; i < count; i++) {
            String[] tokens = scanner.nextLine().split(" ");
            Car car = new Car(tokens[0] , Double.parseDouble(tokens[1]) , Double.parseDouble(tokens[2]));
            cars.put(tokens[0] , car);
        }

        String input = scanner.nextLine();
        while (!input.equals("End")){
            String[] tokens = input.split(" ");
            cars.get(tokens[1]).drive(Integer.parseInt(tokens[2]));
            input = scanner.nextLine();
        }

        cars.values().forEach(c -> System.out.printf("%s %.2f %d%n",c.getModel() , c.getFuelAmount() , c.getDistance()));
    }
}
