import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String , Integer> resources = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("stop")){
            String material = input;
            int quantity = Integer.parseInt(scanner.nextLine());
            resources.putIfAbsent(material , 0);
            resources.put(material , resources.get(material) + quantity);

            input = scanner.nextLine();
        }
        for (Map.Entry<String, Integer> e : resources.entrySet()) {
            System.out.println(e.getKey() + " -> " + e.getValue());
        }
    }
}
