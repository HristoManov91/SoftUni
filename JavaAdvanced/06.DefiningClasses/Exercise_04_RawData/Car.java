package Exercise_04_RawData;

import java.util.List;

public class Car {
    private String model;
    private Engine engine;
    private Cargo cargo;
    private List<Tire> tires;

    public Car(String model, Engine engine, Cargo cargo, List<Tire> tires) {
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tires = tires;
    }

    public String getModel() {
        return this.model;
    }

    public Cargo getCargo() {
        return this.cargo;
    }

    public Engine getEngine() {
        return this.engine;
    }

    public List<Tire> getTires() {
        return this.tires;
    }

    public double getAveragePressure () {
        return this.getTires().stream().mapToDouble(Tire::getPressure).average().getAsDouble();
    }
}
