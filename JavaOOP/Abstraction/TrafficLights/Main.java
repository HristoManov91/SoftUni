package TrafficLights;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] startLights = scanner.nextLine().split(" ");
        int count = Integer.parseInt(scanner.nextLine());

        List<TrafficLights> trafficLights = new ArrayList<>();

        for (String light : startLights) {
            TrafficLights trafficLight = new TrafficLights(Lights.valueOf(light));
            trafficLights.add(trafficLight);
        }
        for (int i = 0; i < count; i++) {
            for (TrafficLights light : trafficLights) {
                light.update();
                System.out.print(light.getLights() + " ");
            }
            System.out.println();
        }
    }
}
