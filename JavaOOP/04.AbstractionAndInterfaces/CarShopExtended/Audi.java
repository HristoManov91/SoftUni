package CarShopExtended;

public class Audi extends CarImpl implements Rentable {

    private Integer minRentDay;
    private Double pricePerDay;


    public Audi(String model, String color, Integer horsepower, String countryProduced,Integer minRentDay ,
                Double pricePerDay) {
        super(model, color, horsepower, countryProduced);
        this.pricePerDay = pricePerDay;
        this.minRentDay = minRentDay;
    }

    @Override
    public Integer getMinRentDay() {
        return this.minRentDay;
    }

    @Override
    public Double getPricePerDay() {
        return this.pricePerDay;
    }

    @Override
    public String toString() {
        return super.toString() + System.lineSeparator()
                + String.format("Minimum rental period of %d days. Price per day %f",
                getMinRentDay() , getPricePerDay());
    }
}
