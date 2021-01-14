package PizzaCalories;

import java.util.Map;

public class Topping {
//    Вместо да правим class enum може така с Map да ги изброим
//    private static final Map<String , Double> TOPPING_TYPES_WITH_MODIFIERS =
//            Map.of("Meat" , 1.2, "Veggies" , 0.8, "Cheese" , 1.1 , "Sauce" , 0.9);

    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
        this.setToppingType(toppingType);
        this.setWeight(weight);
    }

    private void setToppingType(String toppingType) {
        if (TypeOfToppings.CHEESE.toString().equals(toppingType.toUpperCase())
                || TypeOfToppings.MEAT.toString().equals(toppingType.toUpperCase())
                || TypeOfToppings.SAUCE.toString().equals(toppingType.toUpperCase())
                || TypeOfToppings.VEGGIES.toString().equals(toppingType.toUpperCase())) {
            this.toppingType = toppingType;
        } else {
            throw new IllegalArgumentException("Cannot place " + toppingType + " on top of your pizza.");
        }
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 50) {
            throw new IllegalArgumentException(this.getToppingType() + " weight should be in the range [1..50].");
        }
        this.weight = weight;
    }

    public double calculateCalories() {
        return this.weight * 2 * TypeOfToppings.valueOf(this.toppingType.toUpperCase()).getCalories();
    }

    public String getToppingType() {
        return this.toppingType;
    }
}
