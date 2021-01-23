import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ProductShop_06_Lab {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String , Map<String , Double>> shopProductList = new TreeMap<>();

        String input = scanner.nextLine();
        while (!input.equals("Revision")){
            String[] tokens = input.split(", ");
            String shop = tokens[0];
            String product = tokens[1];
            double price = Double.parseDouble(tokens[2]);

            shopProductList.putIfAbsent(shop , new LinkedHashMap<>());
            shopProductList.get(shop).put(product , price);

            input = scanner.nextLine();
        }

        shopProductList.entrySet()
                .stream()
                .forEach(s -> {
                    System.out.println(s.getKey() + "->");
                    s.getValue()
                            .forEach((key, value) -> System.out.printf("Product: %s, Price: %.1f%n", key, value));
                });
    }
}
