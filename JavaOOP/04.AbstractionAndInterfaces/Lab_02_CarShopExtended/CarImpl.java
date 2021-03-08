package Lab_02_CarShopExtended;

public abstract class CarImpl implements Car{
    private String model;
    private String color;
    private Integer horsepower;
    private String countryProduced;

    protected CarImpl(String model, String color, Integer horsePower, String countryProduced) {
        this.model = model;
        this.color = color;
        this.horsepower = horsePower;
        this.countryProduced = countryProduced;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public Integer getHorsePower() {
        return this.horsepower;
    }

    @Override
    public String getColor() {
        return this.color;
    }

    public String countryProduced() {
        return this.countryProduced;
    }

    @Override
    public String toString() {
        return String.format("This is %s produced in %s and have %d tires", getModel() , countryProduced() , TYRES);
    }
}
