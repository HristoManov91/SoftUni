package Exercise_04_RawData;

public class Cargo {
    private int cargoWeight;
    private String cargoType;

    public Cargo(int cargoWeight, String cargoType) {
        this.cargoWeight = cargoWeight;
        this.cargoType = cargoType;
    }

    public int getCargoWeight() {
        return this.cargoWeight;
    }

    public String getCargoType() {
        return this.cargoType;
    }
}
