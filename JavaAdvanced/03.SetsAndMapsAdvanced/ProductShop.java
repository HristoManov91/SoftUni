import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String , Map<String , Double>> productInformation = new TreeMap<>();

        String input = scanner.nextLine();
        while (!input.equals("Revision")){
            String[] tokens = input.split(", ");
            String shop = tokens[0];
            String product = tokens[1];
            double price = Double.parseDouble(tokens[2]);

            productInformation.putIfAbsent(shop , new LinkedHashMap<>());
            productInformation.get(shop).put(product , price);

            input = scanner.nextLine();
        }

        productInformation
                .entrySet()
                .stream()
                .forEach(s -> {
                    System.out.println(s.getKey() + "->");
                            s.getValue().entrySet().stream()
                                    .forEach(p -> System.out.printf("Product: %s, Price: %.1f%n",p.getKey() , p.getValue()));
                });

    }
}
