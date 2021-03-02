package Exercise_04_PizzaCalories;

import PizzaCalories.TypeOfToppings;

public class Topping {
    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
        setToppingType(toppingType);
        setWeight(weight);
    }

    public String getToppingType() {
        return this.toppingType;
    }

    private void setToppingType(String toppingType) {
        if (ToppingsModifiers.valueOf(toppingType.toUpperCase()).getModifier() != 0){
            this.toppingType = toppingType;
        } else {
            throw new IllegalArgumentException("Cannot place " + toppingType + " on top of your pizza.");
        }
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 50){
            throw new IllegalArgumentException(this.getToppingType() + " weight should be in the range [1..50].");
        }
        this.weight = weight;
    }

    public double calculateCalories(){
        return this.weight * 2 * TypeOfToppings.valueOf(this.toppingType.toUpperCase()).getCalories();
    }
}
