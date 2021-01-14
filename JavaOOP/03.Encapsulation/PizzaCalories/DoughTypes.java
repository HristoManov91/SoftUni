package PizzaCalories;

public enum DoughTypes {
    WHITE (1.5),
    WHOLEGRAIN (1.0);

    private double calories;

    DoughTypes(double calories) {
        this.calories = calories;
    }

    public double getCalories() {
        return this.calories;
    }
}
