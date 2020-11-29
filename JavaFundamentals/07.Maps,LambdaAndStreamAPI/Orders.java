import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String , Integer> productQuantity = new LinkedHashMap<>();
        Map<String , Double> productPrice = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("buy")){
            String[] data = input.split(" ");
            String product = data[0];
            double price = Double.parseDouble(data[1]);
            int quantity = Integer.parseInt(data[2]);
            productQuantity.putIfAbsent(product , 0);
            int newQuantity = productQuantity.get(product) + quantity;
            productQuantity.put(product , newQuantity);
            productPrice.putIfAbsent(product , 0.0);
            productPrice.put(product , price);

            input = scanner.nextLine();
        }
        Map<String , Double> output = new LinkedHashMap<>();
        for (var product : productQuantity.entrySet()){
            double totalPrice = productQuantity.get(product.getKey()) * productPrice.get(product.getKey());
            output.put(product.getKey() , totalPrice);
        }

        output
                .entrySet()
                .stream()
                .forEach(p -> System.out.printf("%s -> %.2f%n",p.getKey() , p.getValue()));
    }
}
