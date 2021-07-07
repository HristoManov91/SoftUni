package entity;

import javax.persistence.*;

@Entity
@Table (name = "players_statistics")
public class PlayerStatistic extends BaseEntity {

    private Game game;
    private Player player;
    private Integer scoredGoals;
    private Integer playerAssists;
    private Float playerMinutes;

    public PlayerStatistic() {
    }

    @ManyToOne
    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    @ManyToOne
    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    @Column (name = "scored_goals")
    public Integer getScoredGoals() {
        return scoredGoals;
    }

    public void setScoredGoals(Integer scoredGoals) {
        this.scoredGoals = scoredGoals;
    }

    @Column (name = "player_assists")
    public Integer getPlayerAssists() {
        return playerAssists;
    }

    public void setPlayerAssists(Integer playerAssists) {
        this.playerAssists = playerAssists;
    }

    @Column (name = "player_minutes")
    public Float getPlayerMinutes() {
        return playerMinutes;
    }

    public void setPlayerMinutes(Float playerMinutes) {
        this.playerMinutes = playerMinutes;
    }
}
