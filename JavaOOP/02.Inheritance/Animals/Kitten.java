package Animals;

public class Kitten extends Cat{
    public Kitten(String name, int age , String gender) {
        super(name, age, gender);
    }

    @Override
    public String produceSound() {
        return "Meow";
    }
}
