package Google;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String namePerson;
    private Company company;
    private Car car;
    private List<Pokemon> pokemon = new ArrayList<>();
    private List<Parents> parents = new ArrayList<>();
    private List<Children> children = new ArrayList<>();

    public void setNamePerson(String namePerson) {
        this.namePerson = namePerson;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getNamePerson() {
        return this.namePerson;
    }

    public Company getCompany() {
        return this.company;
    }

    public Car getCar() {
        return this.car;
    }

    public List<Pokemon> getPokemon() {
        return this.pokemon;
    }

    public List<Parents> getParents() {
        return this.parents;
    }

    public List<Children> getChildren() {
        return this.children;
    }
}
