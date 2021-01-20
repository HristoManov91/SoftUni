package WildFarm;

import java.text.DecimalFormat;

public abstract class Animal {
    private String animalName;
    private String animalType;
    private Double animalWeight;
    private int foodEaten;
    private String livingRegion;

    protected Animal(String animalName, String animalType, Double animalWeight , String livingRegion) {
        this.animalName = animalName;
        this.animalType = animalType;
        this.animalWeight = animalWeight;
        this.livingRegion = livingRegion;
    }

    protected String getAnimalType() {
        return animalType;
    }

    public abstract void makeSound ();

    public void eat (Food food){
        this.foodEaten += food.getQuantity();
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("0.###");
        return String.format("%s[%s, %s, %s, %d]", this.animalType , this.animalName ,
                df.format(this.animalWeight) ,  this.livingRegion , this.foodEaten);
    }
}
