package entity;

import javax.persistence.*;

@Entity
@Table (name = "bet_games")
public class BetGame extends BaseEntity {

    private Game game;
    private Bet bet;
    private ResultPrediction resultPrediction;

    public BetGame() {
    }

    @ManyToOne
    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    @ManyToOne
    public Bet getBet() {
        return bet;
    }

    public void setBet(Bet bet) {
        this.bet = bet;
    }

    @ManyToOne
    public ResultPrediction getResultPrediction() {
        return resultPrediction;
    }

    public void setResultPrediction(ResultPrediction resultPrediction) {
        this.resultPrediction = resultPrediction;
    }
}
