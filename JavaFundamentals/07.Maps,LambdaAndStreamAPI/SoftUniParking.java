import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SoftUniParking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countCommands = Integer.parseInt(scanner.nextLine());
        Map<String , String> parkingInfo = new LinkedHashMap<>();

        for (int i = 1; i <= countCommands; i++) {
            String[] input = scanner.nextLine().split(" ");
            String command = input[0];
            String name = input[1];
            switch (command){
                case "register":
                    String id = input[2];
                    if (parkingInfo.containsKey(name)){
                        System.out.printf("ERROR: already registered with plate number %s%n", parkingInfo.get(name));
                    } else {
                        parkingInfo.put(name , id);
                        System.out.printf("%s registered %s successfully%n", name , id);
                    }
                    break;
                case "unregister":
                    if (parkingInfo.containsKey(name)){
                        parkingInfo.remove(name);
                        System.out.printf("%s unregistered successfully%n", name);
                    } else {
                        System.out.printf("ERROR: user %s not found%n", name);
                    }
                    break;
            }
        }
        parkingInfo
                .entrySet()
                .stream()
                .forEach(e -> System.out.printf("%s => %s%n", e.getKey() , e.getValue()));
    }
}
