package Exercise_03_SpeedRacing;

public class Car {
    private String model;
    private double fuelAmount;
    private final double fuelCostForOneKilometres;
    private int distance;

    public Car(String model, double fuelAmount, double fuelCostForOneKilometres) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCostForOneKilometres = fuelCostForOneKilometres;
        this.distance = 0;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    public void setFuelAmount(double fuelAmount) {
        this.fuelAmount = fuelAmount;
    }

    public double getFuelCostForOneKilometres() {
        return fuelCostForOneKilometres;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public void drive (int distance){
        if (this.getFuelAmount() / this.getFuelCostForOneKilometres() > distance){
            this.setFuelAmount(this.getFuelAmount() - this.getFuelCostForOneKilometres() * distance);
            this.setDistance((this.getDistance() + distance));
        } else {
            System.out.println("Insufficient fuel for the drive");
        }
    }
}
