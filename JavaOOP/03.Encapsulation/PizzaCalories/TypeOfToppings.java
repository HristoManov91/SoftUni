package PizzaCalories;

public enum TypeOfToppings {
    //•	Meat – 1.2;
    //•	Veggies – 0.8;
    //•	Cheese – 1.1;
    //•	Sauce – 0.9;
    MEAT (1.2),
    VEGGIES (0.8),
    CHEESE (1.1),
    SAUCE (0.9);

    private double calories;

    TypeOfToppings (double calories){
        this.calories = calories;
    }

    public double getCalories() {
        return this.calories;
    }
}
