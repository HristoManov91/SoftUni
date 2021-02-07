package Exercise_07_Google;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private Company company;
    private Car car;
    private List<Pokemon> pokemonList;
    private List<Parents> parentsList;
    private List<Children> childrenList;

    public Person(String name) {
        this.name = name;
        this.company = null;
        this.car = null;
        this.pokemonList = new ArrayList<>();
        this.parentsList = new ArrayList<>();
        this.childrenList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public Company getCompany() {
        return company;
    }

    public Car getCar() {
        return car;
    }

    public List<Pokemon> getPokemonList() {
        return pokemonList;
    }

    public List<Parents> getParentsList() {
        return parentsList;
    }

    public List<Children> getChildrenList() {
        return childrenList;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(System.lineSeparator());
        sb.append("Company:").append(System.lineSeparator());
        if (company != null) {
            sb.append(company.getCompanyName()).append(" ").append(company.getDepartment()).append(" ")
                    .append(String.format("%.2f", company.getSalary())).append(System.lineSeparator());
        }
        sb.append("Car:").append(System.lineSeparator());
        if (car != null) {
            sb.append(car.getCarModel()).append(" ").append(car.getCarSpeed()).append(System.lineSeparator());
        }
        sb.append("Pokemon:").append(System.lineSeparator());
        if (!pokemonList.isEmpty()) {
            for (Pokemon pokemon : pokemonList) {
                sb.append(pokemon.getPokemonName()).append(" ").append(pokemon.getPokemonType()).append(System.lineSeparator());
            }
        }
        sb.append("Parents:").append(System.lineSeparator());
        if (!parentsList.isEmpty()) {
            for (Parents parents : parentsList) {
                sb.append(parents.getParents()).append(" ").append(parents.getParentsBirthday()).append(System.lineSeparator());
            }
        }
        sb.append("Children:").append(System.lineSeparator());
        if (!childrenList.isEmpty()) {
            for (Children children : childrenList) {
                sb.append(children.getChildren()).append(" ").append(children.getChildBirthday()).append(System.lineSeparator());
            }
        }
        return sb.toString();
    }
}
