package Lab_04_HotelReservation;

public enum Discount {
    NONE(0) ,
    SECONDVISIT(10) ,
    VIP (20) ;

    private int discount;

    Discount(int value){
        this.discount = value;
    }

    public int getDiscount() {
        return this.discount;
    }
}
