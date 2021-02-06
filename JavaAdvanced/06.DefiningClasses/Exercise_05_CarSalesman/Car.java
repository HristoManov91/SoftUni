package Exercise_05_CarSalesman;

public class Car {
    private String model;
    private Engine engine;
    private int weight;
    private String color;

    public Car(String model, Engine engine) {
        this.model = model;
        this.engine = engine;
        this.weight = -1;
        this.color = "n/a";
    }

    public Car(String model , Engine engine , int weight){
        this(model , engine);
        this.weight = weight;
    }

    public Car (String model , Engine engine , String color){
        this(model, engine);
        this.color = color;
    }

    public Car (String model , Engine engine , int weight , String color){
        this(model, engine, weight);
        this.color = color;
    }

    public String getModel() {
        return model;
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
        //FordFocus:
        //V4-33:
        //Power: 140
        //Displacement: 28
        //Efficiency: B
        //Weight: 1300
        //Color: Silver
        StringBuilder sb = new StringBuilder();
        sb.append(model).append(':').append(System.lineSeparator());
        sb.append(engine.getModel()).append(':').append(System.lineSeparator());
        sb.append("Power: ").append(engine.getPower()).append(System.lineSeparator());
        sb.append("Displacement: ").append(engine.getDisplacement() == -1 ? "n/a" : engine.getDisplacement())
                .append(System.lineSeparator());
        sb.append("Efficiency: ").append(engine.getEfficiency()).append(System.lineSeparator());
        sb.append("Weight: ").append(this.getWeight() == -1 ? "n/a" : this.getWeight()).append(System.lineSeparator());
        sb.append("Color: ").append(this.getColor());
        return sb.toString();
    }
}
