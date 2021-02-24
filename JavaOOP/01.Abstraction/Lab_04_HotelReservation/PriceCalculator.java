package Lab_04_HotelReservation;

public class PriceCalculator {
    private double pricePerDay;
    private int countDays;
    private Season season;
    private Discount discount;

    public PriceCalculator(double pricePerDay , int countDays , Season season , Discount discount){
        this.pricePerDay = pricePerDay;
        this.countDays = countDays;
        this.season = season;
        this.discount = discount;
    }

    public double calculatePriceForHoliday(){
        return this.countDays * (this.pricePerDay * this.season.getMultiplier()) * (1.00 - (this.discount.getDiscount() / 100.00));
    }
}
