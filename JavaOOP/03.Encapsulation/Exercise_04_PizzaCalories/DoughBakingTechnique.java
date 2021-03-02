package Exercise_04_PizzaCalories;

public enum DoughBakingTechnique {
    CRISPY (0.9),
    CHEWY (1.1),
    HOMEMADE (1.0);

    private double modifier;


    DoughBakingTechnique(double modifier) {
        this.modifier = modifier;
    }

    public double getModifier() {
        return this.modifier;
    }
}
