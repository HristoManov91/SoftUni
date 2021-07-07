package entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table (name = "continents")
public class Continent extends BaseEntity{

    private String name;
    private Set<Country> countries;

    public Continent() {
    }

    @Column (name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany
    public Set<Country> getCountries() {
        return countries;
    }

    public void setCountries(Set<Country> countries) {
        this.countries = countries;
    }
}
