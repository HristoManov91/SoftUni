package PizzaCalories;

public class Dough {
    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {
        this.setFlourType(flourType);
        this.setBakingTechnique(bakingTechnique);
        this.setWeight(weight);
    }

    private void setFlourType(String flourType) {
        if (DoughTypes.values()[0].toString().equals(flourType.toUpperCase()) ||
                DoughTypes.values()[1].toString().equals(flourType.toUpperCase())) {
            this.flourType = flourType;
        } else {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
    }

    private void setBakingTechnique(String bakingTechnique) {
        if (DoughBakingTechnique.values()[0].toString().equals(bakingTechnique.toUpperCase()) ||
                DoughBakingTechnique.values()[1].toString().equals(bakingTechnique.toUpperCase()) ||
                DoughBakingTechnique.values()[2].toString().equals(bakingTechnique.toUpperCase())) {
            this.bakingTechnique = bakingTechnique;
        } else {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 200) {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        this.weight = weight;
    }

    public double calculateCalories() {
        return (2 * weight * DoughTypes.valueOf(flourType.toUpperCase()).getCalories() *
                DoughBakingTechnique.valueOf(bakingTechnique.toUpperCase()).getCalories());
    }
}
