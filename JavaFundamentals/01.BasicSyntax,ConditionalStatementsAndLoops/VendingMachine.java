import java.util.Scanner;
import java.util.function.DoublePredicate;

public class VendingMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double moneyHave = 0.0;
        String input = scanner.nextLine();
        while (!input.equals("Start")){
            switch (input){
                case "0.1":
                    moneyHave += 0.1;
                    break;
                case "0.2":
                    moneyHave += 0.2;
                    break;
                case "0.5":
                    moneyHave += 0.5;
                    break;
                case "1":
                    moneyHave += 1;
                    break;
                case "2":
                    moneyHave += 2;
                    break;
                default:
                    double temp = Double.parseDouble(input);
                    System.out.printf("Cannot accept %.2f%n", temp);
                    break;
            }
            input = scanner.nextLine();
        }
        String purchaseElement = scanner.nextLine();
        while (!purchaseElement.equals("End")){
            switch (purchaseElement){
                case "Nuts":
                    if ( moneyHave >= 2){
                        moneyHave -= 2;
                        System.out.printf("Purchased %s%n", purchaseElement);
                    } else {
                        System.out.println("Sorry, not enough money");
                    }
                    break;
                case "Water":
                    if ( moneyHave >= 0.7){
                        moneyHave -= 0.7;
                        System.out.printf("Purchased %s%n", purchaseElement);
                    } else {
                        System.out.println("Sorry, not enough money");
                    }
                    break;
                case "Crisps":
                    if ( moneyHave >= 1.5){
                        moneyHave -= 1.5;
                        System.out.printf("Purchased %s%n", purchaseElement);
                    } else {
                        System.out.println("Sorry, not enough money");
                    }
                    break;
                case "Soda":
                    if ( moneyHave >= 0.8){
                        moneyHave -= 0.8;
                        System.out.printf("Purchased %s%n", purchaseElement);
                    } else {
                        System.out.println("Sorry, not enough money");
                    }
                    break;
                case "Coke":
                    if ( moneyHave >= 1){
                        moneyHave -= 1;
                        System.out.printf("Purchased %s%n", purchaseElement);
                    } else {
                        System.out.println("Sorry, not enough money");
                    }
                    break;
                default:
                    System.out.println("Invalid product");
                    break;
            }
//            if ( moneyHave >= priceOfProduct && priceOfProduct != 0.0){
//                moneyHave -= priceOfProduct;
//                System.out.printf("Purchased %s%n", purchaseElement);
//            } else if ( moneyHave < priceOfProduct){
//                System.out.println("Sorry, not enough money");
//            }
            purchaseElement = scanner.nextLine();
        }
        System.out.printf("Change: %.2f", moneyHave);
    }
}
