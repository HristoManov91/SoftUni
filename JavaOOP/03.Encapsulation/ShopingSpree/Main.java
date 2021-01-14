package ShopingSpree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Person> people = new ArrayList<>();

        String[] personInfo = scanner.nextLine().split(";");
        for (String info : personInfo) {
            try {
                Person person = new Person(info.split("=")[0] , Double.parseDouble(info.split("=")[1]));
                people.add(person);
            } catch (Exception ex){
                System.out.println(ex.getMessage());
            }
        }

        List<Product> products = new ArrayList<>();
        String[] productInfo = scanner.nextLine().split(";");
        for (String item : productInfo) {
            try {
                Product product = new Product(item.split("=")[0], Double.parseDouble(item.split("=")[1]));
                products.add(product);
            } catch (Exception ex){
                System.out.println(ex.getMessage());
            }
        }

        String command = scanner.nextLine();
        while (!command.equals("END")){
            String[] tokens = command.split(" ");
            for (Person person : people) {
                if (person.getName().equals(tokens[0])){
                    for (Product product : products) {
                        if (product.getName().equals(tokens[1])){
                            person.buyProduct(product);
                            break;
                        }
                    }
                }
            }
            command = scanner.nextLine();
        }
        for (Person person : people) {
            System.out.println(person.toString());
        }
    }
}
