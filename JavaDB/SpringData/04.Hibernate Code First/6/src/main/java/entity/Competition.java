package entity;

import javax.persistence.*;

@Entity
@Table (name = "competitions")
public class Competition extends BaseEntity {

    private String name;
    private CompetitionType competitionType;

    public Competition() {
    }

    @Column
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToOne
    public CompetitionType getCompetitionType() {
        return competitionType;
    }

    public void setCompetitionType(CompetitionType competitionType) {
        this.competitionType = competitionType;
    }
}
