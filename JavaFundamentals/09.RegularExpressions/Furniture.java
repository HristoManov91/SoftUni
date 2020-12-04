import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Furniture {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String regex = ">>(?<furniture>[A-Za-z]+)<<(?<price>\\d+\\.*\\d+)!(?<quantity>\\d+)";
        String input = scanner.nextLine();

        Pattern pattern = Pattern.compile(regex);

        List<String> boughtFurniture = new ArrayList<>();
        double totalMoneySpend = 0;

        while (!input.equals("Purchase")){
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()){
                String furniture = matcher.group("furniture");
                boughtFurniture.add(furniture);
                int quantity = Integer.parseInt(matcher.group("quantity"));
                double price = Double.parseDouble(matcher.group("price"));
                totalMoneySpend += quantity * price;
            }
            input = scanner.nextLine();
        }
        System.out.println("Bought furniture:");
        for (String element : boughtFurniture) {
            System.out.println(element);
        }
        System.out.printf("Total money spend: %.2f", totalMoneySpend);
    }
}
