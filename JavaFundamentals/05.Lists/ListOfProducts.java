import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ListOfProducts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countProducts = Integer.parseInt(scanner.nextLine());
        List<String> products = new ArrayList<>(4);
        for (int i = 0; i < countProducts; i++) {
            String product = scanner.nextLine();
            products.add(product);
        }
        Collections.sort(products);
        for (int i = 1; i <= products.size(); i++) {
            System.out.printf("%d.%s%n", i , products.get(i - 1));
        }
    }
}
