package Exercise_04_TrafficLights;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");

        List<TrafficLights> trafficLights = new ArrayList<>();
        for (String s : input) {
            TrafficLights trafficLight = new TrafficLights(Lights.valueOf(s));
            trafficLights.add(trafficLight);
        }

        int count = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < count; i++) {
            for (TrafficLights trafficLight : trafficLights) {
                trafficLight.swapLights();
                System.out.print(trafficLight.getLights() + " ");
            }
            System.out.println();
        }
    }
}
