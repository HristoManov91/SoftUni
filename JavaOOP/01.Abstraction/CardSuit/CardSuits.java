package CardSuit;

public enum CardSuits {
    //CLUBS, DIAMONDS, HEARTS, SPADES
    CLUBS,
    DIAMONDS,
    HEARTS,
    SPADES;

    @Override
    public String toString() {
        //Ordinal value: 0; Name value: CLUBS
        return String.format("Ordinal value: %d; Name value: %s",this.ordinal() , this.name());
    }
}
