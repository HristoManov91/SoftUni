package CardsWithPower;

public enum SuitsPower {
    //(CLUBS - 0, DIAMONDS - 13, HEARTS - 26, SPADES - 39).
    CLUBS(0),
    DIAMONDS(13),
    HEARTS(26),
    SPADES(39);

    private int value;

    SuitsPower(int value){
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
