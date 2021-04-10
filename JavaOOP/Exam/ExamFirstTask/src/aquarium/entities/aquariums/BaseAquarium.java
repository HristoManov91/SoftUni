package aquarium.entities.aquariums;

import aquarium.entities.decorations.Decoration;
import aquarium.entities.fish.Fish;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import static aquarium.common.ConstantMessages.*;
import static aquarium.common.ExceptionMessages.*;

public abstract class BaseAquarium implements Aquarium{
    private String name;
    private int capacity;
    private Collection<Decoration> decorations;
    private Collection<Fish> fish;

    protected BaseAquarium(String name, int capacity) {
        setName(name);
        this.capacity = capacity;
        this.decorations = new ArrayList<>();
        this.fish = new ArrayList<>();
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()){
            throw new NullPointerException(AQUARIUM_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public int calculateComfort() {
        return this.decorations.stream().mapToInt(Decoration::getComfort).sum();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void addFish(Fish fish) {
        if (this.getFish().size() == this.capacity){
            throw new IllegalStateException(NOT_ENOUGH_CAPACITY);
        }
        this.fish.add(fish);
    }

    @Override
    public void removeFish(Fish fish) {
        this.fish.remove(fish);
    }

    @Override
    public void addDecoration(Decoration decoration) {
        this.decorations.add(decoration);
    }

    @Override
    public void feed() {
        this.fish.forEach(Fish::eat);
    }

    @Override
    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        //"{aquariumName} ({aquariumType}):
        //Fish: {fishName1} {fishName2} {fishName3} (…) / Fish: none
        //Decorations: {decorationsCount}
        //Comfort: {aquariumComfort}"
        sb.append(String.format("%s (%s):", this.getName() , this.getClass().getSimpleName())).append(System.lineSeparator());
        sb.append("Fish: ").append(
                this.getFish().isEmpty()
                        ? "none"
                        : this.getFish().stream().map(Fish::getName).collect(Collectors.joining(" ")))
                .append(System.lineSeparator());
        sb.append("Decorations: ").append(this.getDecorations().size()).append(System.lineSeparator());
        sb.append("Comfort: ").append(this.getDecorations().stream().mapToInt(Decoration::getComfort).sum())
                .append(System.lineSeparator());

        return sb.toString().trim();
    }

    @Override
    public Collection<Fish> getFish() {
        return this.fish;
    }

    @Override
    public Collection<Decoration> getDecorations() {
        return this.decorations;
    }
}
