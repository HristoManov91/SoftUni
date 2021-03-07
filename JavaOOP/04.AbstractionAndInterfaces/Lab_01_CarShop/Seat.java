package Lab_01_CarShop;

import java.io.Serializable;

public class Seat implements Car , Serializable {
    private String model;
    private String color;
    private Integer horsepower;
    private String countryProduced;

    public Seat(String model, String color, Integer horsePower, String countryProduced) {
        this.model = model;
        this.color = color;
        this.horsepower = horsePower;
        this.countryProduced = countryProduced;
    }

    @Override
    public String toString() {
        return String.format("This is %s produced in %s and have %d tires", getModel() , countryProduced() , TYRES);
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public Integer getHorsePower() {
        return this.horsepower;
    }

    @Override
    public String countryProduced() {
        return this.countryProduced;
    }
}
