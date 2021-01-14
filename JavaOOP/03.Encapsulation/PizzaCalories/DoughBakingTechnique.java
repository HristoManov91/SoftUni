package PizzaCalories;

public enum DoughBakingTechnique {
    CRISPY (0.9),
    CHEWY (1.1),
    HOMEMADE (1.0);

    private double calories;


    DoughBakingTechnique(double calories) {
        this.calories = calories;
    }

    public double getCalories() {
        return this.calories;
    }
}
