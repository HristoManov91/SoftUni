package Lab_02_CarShopExtended;

public class Seat extends CarImpl implements Sellable {
    private Double price;

    public Seat(String model, String color, Integer horsePower, String countryProduced , double price) {
        super(model, color, horsePower, countryProduced);
        this.price = price;
    }

    public Double getPrice() {
        return this.price;
    }

    @Override
    public String toString() {
        return super.toString() + System.lineSeparator()
                + String.format("%s sells for %f", getModel() , getPrice());

    }
}
