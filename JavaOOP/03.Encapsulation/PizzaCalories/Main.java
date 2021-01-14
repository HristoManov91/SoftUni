package PizzaCalories;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Pizza> pizzaList = new ArrayList<>();
        String input = scanner.nextLine();
        while (!input.equals("END")){
            String[] tokens = input.split(" ");
            switch (tokens[0]){
                case "Pizza":
                    try {
                        Pizza pizza = new Pizza(tokens[1] , Integer.parseInt(tokens[2]));
                        pizzaList.add(pizza);
                    } catch (Exception ex){
                        System.out.println(ex.getMessage());
                        return;
                    }
                    break;
                case "Dough":
                    try {
                        Dough dough = new Dough(tokens[1] , tokens[2] , Double.parseDouble(tokens[3]));
                        pizzaList.get(0).setDough(dough);
                    } catch (Exception ex){
                        System.out.println(ex.getMessage());
                        return;
                    }
                    break;
                case "Topping":
                    try {
                        Topping topping = new Topping(tokens[1] , Double.parseDouble(tokens[2]));
                        pizzaList.get(0).addTopping(topping);
                    } catch (Exception ex){
                        System.out.println(ex.getMessage());
                        return;
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.println(pizzaList.get(0).getName() + " - " + pizzaList.get(0).getOverallCalories());
    }
}
