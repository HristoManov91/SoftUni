package entity;

import javax.persistence.*;

@Entity
@Table (name = "teams")
public class Team extends BaseEntity {

    private String name;
    private String logo;
    private String initials;
    private Color primaryKitColor;
    private Color secondaryKitColor;
    private Town town;
    private Float budget;

    public Team() {
    }

    @Column (name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column (name = "logo" , columnDefinition = "BLOB")
    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    @Column (name = "initials" , length = 3)
    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

    @ManyToOne
    public Color getPrimaryKitColor() {
        return primaryKitColor;
    }

    public void setPrimaryKitColor(Color primaryKitColor) {
        this.primaryKitColor = primaryKitColor;
    }

    @ManyToOne
    public Color getSecondaryKitColor() {
        return secondaryKitColor;
    }

    public void setSecondaryKitColor(Color secondaryKitColor) {
        this.secondaryKitColor = secondaryKitColor;
    }

    @ManyToOne
    public Town getTown() {
        return town;
    }

    public void setTown(Town town) {
        this.town = town;
    }

    @Column (name = "budget")
    public Float getBudget() {
        return budget;
    }

    public void setBudget(Float budget) {
        this.budget = budget;
    }
}
