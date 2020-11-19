import java.util.Scanner;

public class GamingStore {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double budget = Double.parseDouble(scan.nextLine());

        boolean stop = true;
        double spentMoney = 0;

        while (stop) {
            String input = scan.nextLine();
            if (input.equals("Game Time")) {
                stop = false;
                break;
            }
            switch (input) {
                case "OutFall 4":
                    if (39.99 >= budget) {
                        System.out.println("Too Expensive");
                    } else {
                        System.out.println("Bought OutFall 4");
                        budget -= 39.99;
                        spentMoney += 39.99;
                    }
                    break;
                case "CS: OG":
                    if (15.99 >= budget) {
                        System.out.println("Too Expensive");
                    } else {
                        System.out.println("Bought CS: OG");
                        budget -= 15.99;
                        spentMoney += 15.99;
                    }
                    break;
                case "Zplinter Zell":
                    if (19.99 >= budget) {
                        System.out.println("Too Expensive");
                    } else {
                        System.out.println("Bought Zplinter Zell");
                        budget -= 19.99;
                        spentMoney += 19.99;
                    }
                    break;
                case "Honored 2":
                    if (59.99 >= budget) {
                        System.out.println("Too Expensive");
                    } else {
                        System.out.println("Bought Honored 2");
                        budget -= 59.99;
                        spentMoney += 59.99;
                    }
                    break;
                case "RoverWatch":
                    if (29.99 >= budget) {
                        System.out.println("Too Expensive");
                    } else {
                        System.out.println("Bought RoverWatch");
                        budget -= 29.99;
                        spentMoney += 29.99;
                    }
                    break;
                case "RoverWatch Origins Edition":
                    if (39.99 >= budget) {
                        System.out.println("Too Expensive");
                    } else {
                        System.out.println("Bought RoverWatch Origins Edition");
                        budget -= 39.99;
                        spentMoney += 39.99;
                    }
                    break;
                default:
                    System.out.println("Not Found");
                    break;
            }
            if ( budget == 0 ){
                System.out.println("Out of money!");
                stop = false;
                break;
            }
        }
        if ( !stop && budget > 0 ){
            System.out.printf("Total spent: $%.2f. Remaining: $%.2f", spentMoney, budget);
        }
    }
}
