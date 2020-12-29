package CarSalesman;

public class Car {
    private String carModel;
    private Engine engine;
    private int weight;
    private String color;

    public Car (String carModel , Engine engine){
        this.carModel = carModel;
        this.engine = engine;
        this.weight = -1;
        this.color = "n/a";
    }

    public Car (String carModel , Engine engine , int weight){
        this(carModel , engine);
        this.weight = weight;
    }

    public Car (String carModel , Engine engine , String color){
        this(carModel , engine);
        this.color = color;
    }

    public Car (String carModel , Engine engine , int weight , String color){
        this(carModel , engine , weight);
        this.color = color;
    }

    public String getCarModel() {
        return carModel;
    }

    public Engine getEngine() {
        return engine;
    }

    public int getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return String.format("%s:%n%s:%n" +
                "Power: %d%n" +
                "Displacement: %s%n" +
                "Efficiency: %s%n" +
                "Weight: %s%n" +
                "Color: %s%n", this.carModel , this.engine.getEngineModel() , this.engine.getPower() ,
                this.engine.getDisplacement() == -1 ? "n/a" : this.engine.getDisplacement(),
                this.engine.getEfficiency(),
                this.weight == -1 ? "n/a" : this.weight , this.color);
    }
}
