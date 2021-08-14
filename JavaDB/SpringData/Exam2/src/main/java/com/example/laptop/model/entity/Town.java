package com.example.laptop.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table (name = "towns")
public class Town extends BasicEntity{

    private String name;
    private Integer population;
    private String travelGuide;

    public Town() {
    }

    @Column (name = "name" , unique = true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column (name = "population")
    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    @Column (name = "travel_guide" , columnDefinition = "TEXT")
    public String getTravelGuide() {
        return travelGuide;
    }

    public void setTravelGuide(String travelGuide) {
        this.travelGuide = travelGuide;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Town)) return false;
        Town town = (Town) o;
        return Objects.equals(name, town.name) && Objects.equals(population, town.population) && Objects.equals(travelGuide, town.travelGuide);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, population, travelGuide);
    }
}
