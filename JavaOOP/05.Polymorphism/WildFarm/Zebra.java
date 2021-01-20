package WildFarm;

public class Zebra extends Mammal {
    protected Zebra(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    public void eat(Food food) {
        if (food instanceof Meat) {
            System.out.println("Zebras are not eating that type of food!");
        } else {
            super.eat(food);
        }
    }

    @Override
    public void makeSound() {
        System.out.println("Zs");
    }
}
