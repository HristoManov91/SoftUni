package CardRank;

public enum CardRank {
    ACE,
    TWO,
    THREE,
    FOUR,
    FIVE,
    SIX,
    SEVEN,
    EIGHT,
    NINE,
    TEN,
    JACK,
    QUEEN,
    KING;
    //Card Ranks:
    //Ordinal value: 0; Name value: ACE
    //Ordinal value: 1; Name value: TWO
    //Ordinal value: 2; Name value: THREE
    //Ordinal value: 3; Name value: FOUR
    //Ordinal value: 4; Name value: FIVE
    //Ordinal value: 5; Name value: SIX
    //Ordinal value: 6; Name value: SEVEN
    //Ordinal value: 7; Name value: EIGHT
    //Ordinal value: 8; Name value: NINE
    //Ordinal value: 9; Name value: TEN
    //Ordinal value: 10; Name value: JACK
    //Ordinal value: 11; Name value: QUEEN
    //Ordinal value: 12; Name value: KING

    @Override
    public String toString() {
        return String.format("Ordinal value: %d; Name value: %s", this.ordinal() , this.name());
    }
}

