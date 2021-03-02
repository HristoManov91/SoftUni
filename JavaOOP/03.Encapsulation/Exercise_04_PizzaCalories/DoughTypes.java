package Exercise_04_PizzaCalories;

public enum DoughTypes {
    WHITE (1.5),
    WHOLEGRAIN (1.0);

    private double modifier;

    DoughTypes(double modifier) {
        this.modifier = modifier;
    }

    public double getModifiers() {
        return this.modifier;
    }
}
