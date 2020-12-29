package CarSalesman;

public class Engine {
    private String engineModel;
    private int power;
    private int displacement;
    private String efficiency;

    public Engine (String engineModel , int power){
        this.engineModel = engineModel;
        this.power = power;
        this.displacement = -1;
        this.efficiency = "n/a";
    }

    public Engine (String engineModel , int power , int displacement){
        this(engineModel , power);
        this.displacement = displacement;
    }

    public Engine (String engineModel ,int power , String efficiency){
        this(engineModel , power);
        this.efficiency = efficiency;
    }

    public Engine (String engineModel , int power , int displacement , String efficiency){
        this(engineModel , power , displacement);
        this.efficiency = efficiency;
    }

    public String getEngineModel() {
        return engineModel;
    }

    public int getPower() {
        return power;
    }

    public int getDisplacement() {
        return displacement;
    }

    public String getEfficiency() {
        return efficiency;
    }
}
