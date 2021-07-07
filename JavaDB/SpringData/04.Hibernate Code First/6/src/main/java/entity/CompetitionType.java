package entity;

import javax.persistence.*;

@Entity
@Table (name = "competition_types")
public class CompetitionType extends BaseEntity {

    private String type;

    public CompetitionType() {
    }

    @Column (name = "types")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
