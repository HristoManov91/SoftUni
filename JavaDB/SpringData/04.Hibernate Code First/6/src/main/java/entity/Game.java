package entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table (name = "games")
public class Game extends BaseEntity {

    private Team homeTeam;
    private Team awayTeam;
    private Integer homeTeamGoals;
    private Integer awayTeamGoals;
    private LocalDateTime dateTime;
    private Float homeTeamWinBetRate;
    private Float awayTeamWinBetRate;
    private Float drawGameBetRate;
    private Round round;
    private Competition competition;

    public Game() {
    }

    @ManyToOne
    public Team getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
    }

    @ManyToOne
    public Team getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(Team awayTeam) {
        this.awayTeam = awayTeam;
    }

    @Column (name = "home_team_goals")
    public Integer getHomeTeamGoals() {
        return homeTeamGoals;
    }

    public void setHomeTeamGoals(Integer homeTeamGoals) {
        this.homeTeamGoals = homeTeamGoals;
    }

    @Column (name = "away_team_goals")
    public Integer getAwayTeamGoals() {
        return awayTeamGoals;
    }

    public void setAwayTeamGoals(Integer awayTeamGoals) {
        this.awayTeamGoals = awayTeamGoals;
    }

    @Column (name = "date_time")
    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    @Column (name = "home_team_bet_rate")
    public Float getHomeTeamWinBetRate() {
        return homeTeamWinBetRate;
    }

    public void setHomeTeamWinBetRate(Float homeTeamWinBetRate) {
        this.homeTeamWinBetRate = homeTeamWinBetRate;
    }

    @Column (name = "away_team_bet_rate")
    public Float getAwayTeamWinBetRate() {
        return awayTeamWinBetRate;
    }

    public void setAwayTeamWinBetRate(Float awayTeamWinBetRate) {
        this.awayTeamWinBetRate = awayTeamWinBetRate;
    }

    @Column (name = "draw_game_bet_rate")
    public Float getDrawGameBetRate() {
        return drawGameBetRate;
    }

    public void setDrawGameBetRate(Float drawGameBetRate) {
        this.drawGameBetRate = drawGameBetRate;
    }

    @ManyToOne
    public Round getRound() {
        return round;
    }

    public void setRound(Round round) {
        this.round = round;
    }

    @OneToOne
    public Competition getCompetition() {
        return competition;
    }

    public void setCompetition(Competition competition) {
        this.competition = competition;
    }
}
