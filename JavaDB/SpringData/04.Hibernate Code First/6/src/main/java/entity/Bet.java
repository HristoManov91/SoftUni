package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table (name = "bets")
public class Bet extends BaseEntity {

    private Float betMoney;
    private LocalDateTime dateTime;
    private User user;

    public Bet() {
    }

    @Column (name = "bet_money")
    public Float getBetMoney() {
        return betMoney;
    }

    public void setBetMoney(Float betMoney) {
        this.betMoney = betMoney;
    }

    @Column (name = "date_time")
    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    @ManyToOne
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
