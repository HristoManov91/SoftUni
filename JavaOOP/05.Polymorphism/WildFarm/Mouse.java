package WildFarm;

public class Mouse extends Mammal {
    protected Mouse(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    public void eat(Food food) {
        if (food instanceof Meat) {
            System.out.println("Mice are not eating that type of food!");
        } else {
            super.eat(food);
        }
    }

    @Override
    public void makeSound() {
        System.out.println("SQUEEEAAAK!");
    }
}
