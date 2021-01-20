package Vehicles;

import java.text.DecimalFormat;

public class Truck {
    private Double fuelQuantity;
    private Double fuelConsumption;

    public Truck (Double fuelQuantity, Double fuelConsumption) {
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
        this.fuelConsumption = fuelConsumption + 1.6;
    }

    public void driving (Double distance){
        if (distance <  getFuelQuantity() / getFuelConsumption()){
            setFuelQuantity(getFuelQuantity() - (distance * getFuelConsumption()));
            DecimalFormat df = new DecimalFormat("0.##");
            System.out.printf("Truck travelled %s km%n", df.format(distance));
        } else {
            System.out.println("Truck needs refueling");
        }
    }

    public void refueling (Double fuel) {
        setFuelQuantity(getFuelQuantity() + (fuel * 0.95));
    }
}
