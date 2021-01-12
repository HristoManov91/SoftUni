package NeedForSpeed;

public class Vehicle {
    private double fuel;
    private int horsePower;
    private double fuelConsumption;

    public Vehicle(double fuel, int horsePower) {
        this.fuel = fuel;
        this.horsePower = horsePower;
        this.fuelConsumption = 1.25;
    }

    public double getFuel() {
        return fuel;
    }

    public void setFuel(double fuel) {
        this.fuel = fuel;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public void drive(double kilometers){
        if (kilometers * this.fuelConsumption <= this.fuel){
            this.fuel -= (kilometers * this.fuelConsumption);
        }
    }
}
