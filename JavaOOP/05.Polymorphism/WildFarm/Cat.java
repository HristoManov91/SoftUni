package WildFarm;

public class Cat extends Felime {
    private String breed;

    public Cat(String animalName, String animalType, Double animalWeight, String livingRegion , String bread) {
        super(animalName, animalType, animalWeight, livingRegion);
        this.breed = bread;
    }

    @Override
    public void makeSound() {
        System.out.println("Meowwww");
    }

    @Override
    public String toString() {
        StringBuilder base = new StringBuilder(super.toString());

        base.insert(base.indexOf(",") + 1, " " + this.breed + ",");
        return base.toString();
    }
}
