package Vehicles;

import java.text.DecimalFormat;

public class Car {
    private Double fuelQuantity;
    private Double fuelConsumption;

    public Car(Double fuelQuantity, Double fuelConsumption) {
        this.fuelQuantity = fuelQuantity;
        setFuelConsumption(fuelConsumption);
    }

    public Double getFuelQuantity() {
        return fuelQuantity;
    }

    public void setFuelQuantity(Double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    public Double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(Double fuelConsumption) {
        this.fuelConsumption = fuelConsumption + 0.9;
    }

    public void driving (Double distance){
        if (distance <  getFuelQuantity() / getFuelConsumption()){
            setFuelQuantity(getFuelQuantity() - (distance * getFuelConsumption()));
            DecimalFormat df = new DecimalFormat("0.##");
            System.out.printf("Car travelled %s km%n", df.format(distance));
        } else {
            System.out.println("Car needs refueling");
        }
    }

    public void refueling (Double fuel) {
        setFuelQuantity(getFuelQuantity() + fuel);
    }
}
