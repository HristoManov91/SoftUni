package Exercise_02_VehiclesExtension;

import java.text.DecimalFormat;

public class Vehicle {
    private double fuelQuantity;
    private double fuelConsumption;
    private double tankCapacity;

    protected Vehicle(Double fuelQuantity, Double fuelConsumption, Double tankCapacity) {
        setFuelQuantity(fuelQuantity);
        this.fuelConsumption = fuelConsumption;
        this.tankCapacity = tankCapacity;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public Double getFuelQuantity() {
        return fuelQuantity;
    }

    public Double getFuelConsumption() {
        return fuelConsumption;
    }

    public Double getTankCapacity() {
        return tankCapacity;
    }

    public void setFuelQuantity(Double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    public void driving (Double distance){
        if (distance < this.getFuelQuantity() / this.getFuelConsumption()){
            setFuelQuantity(getFuelQuantity()-(distance * getFuelConsumption()));
            DecimalFormat df = new DecimalFormat("0.##");
            System.out.printf("%s travelled %s km%n",this.getClass().getSimpleName() , df.format(distance));
        } else {
            System.out.printf("%s needs refueling%n", this.getClass().getSimpleName());
        }
    }

    public void refueling (Double fuel) {
        if (fuel + getFuelQuantity() > getTankCapacity()){
            System.out.println("Cannot fit fuel in tank");
        } else if (fuel <= 0){
            System.out.println("Fuel must be a positive number");
        } else {
            setFuelQuantity(fuel + getFuelQuantity());
        }
    }
}
