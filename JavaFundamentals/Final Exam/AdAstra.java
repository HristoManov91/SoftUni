import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdAstra {

    static class Product {
        String name;
        String date;
        int calories;

        public Product(String name, String date, int calories) {
            this.name = name;
            this.date = date;
            this.calories = calories;
        }

        public String getName() {
            return name;
        }

        public String getDate() {
            return date;
        }

        public int getCalories() {
            return calories;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String regex = "([|#])(?<itemName>[A-Za-z\\s+]+)\\1(?<date>[\\d]{2}\\/[\\d]{2}\\/[\\d]{2})\\1(?<calories>[\\d]+)\\1";
        String text = scanner.nextLine();
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        List<Product> productInfo = new ArrayList<>();

        int totalCalories = 0;
        while (matcher.find()){
            String product = matcher.group("itemName");
            String date = matcher.group("date");
            int calories = Integer.parseInt(matcher.group("calories"));
            totalCalories += calories;
            Product p = new Product(product , date , calories);
            productInfo.add(p);
        }
        System.out.printf("You have food to last you for: %d days!%n", totalCalories / 2000);
        for (Product p : productInfo) {
            System.out.printf("Item: %s, Best before: %s, Nutrition: %d%n", p.getName() , p.getDate() , p.getCalories());
        }
    }
}
