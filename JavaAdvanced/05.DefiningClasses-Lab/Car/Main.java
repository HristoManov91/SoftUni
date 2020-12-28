package Car;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countCar = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < countCar; i++) {
            String[] tokens = scanner.nextLine().split(" ");
            Car car;

            if (tokens.length == 1){
                car = new Car(tokens[0]);
            } else if (tokens.length == 2){
                car = new Car(tokens[0] , tokens[1]);
            } else {
                car = new Car(tokens[0] , tokens[1] , Integer.parseInt(tokens[2]));
            }
            System.out.println(car.toString());
        }
    }
}
