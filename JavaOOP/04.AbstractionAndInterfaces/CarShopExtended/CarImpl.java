package CarShopExtended;

public abstract class CarImpl implements Car{//правим го abstract за да не може да се създава обект от този конструктор
    private String model;
    private String color;
    private Integer horsepower;
    private String countryProduced;

    //правим конструктора protected,за да кажем че само и единствено наследниците на този клас имат достъп до него
    protected CarImpl(String model, String color, Integer horsepower, String countryProduced) {
        this.model = model;
        this.color = color;
        this.horsepower = horsepower;
        this.countryProduced = countryProduced;
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

    @Override
    public String toString() {
        return String.format("This is %s produced in %s and have %d tires", getModel() , countryProduced() , TIRES);
    }
}
