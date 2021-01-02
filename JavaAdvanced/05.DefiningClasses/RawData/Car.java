package RawData;

public class Car {
    private String model;
    private Engine engine;
    private Cargo cargo;
    private Tire tireInfo;

    public Car (String model , Engine engine , Cargo cargo , Tire tireInfo){
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tireInfo = tireInfo;
    }

    public String getModel() {
        return model;
    }

    public Engine getEngine() {
        return engine;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public Tire getTireInfo() {
        return tireInfo;
    }
}
