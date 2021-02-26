package Exercise_01_CardSuit;

public enum CardSuit {
    CLUBS,
    DIAMONDS,
    HEARTS,
    SPADES;

    @Override
    public String toString() {
        return "Ordinal value: " + this.ordinal() + "; Name value: " + this.name();
    }
}
