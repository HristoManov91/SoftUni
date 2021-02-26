package Exercise_03_CardsWithPower;

public class Card {
    private CardRank cardRank;
    private CardSuit cardSuit;

    public Card(CardRank cardRank, CardSuit cardSuit) {
        this.cardRank = cardRank;
        this.cardSuit = cardSuit;
    }

    private int powerOfCard(){
        return this.cardSuit.getValue() + this.cardRank.getValue();
    }

    @Override
    public String toString() {
        return String.format("Card name: %s of %s; Card power: %d", this.cardRank.name() , this.cardSuit.name() ,
                this.powerOfCard());
    }
}
