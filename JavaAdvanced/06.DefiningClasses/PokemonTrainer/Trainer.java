package PokemonTrainer;

import java.util.ArrayList;
import java.util.List;

public class Trainer {
    private String name;
    private int badges;
    private List<Pokemon> pokemonList;

    public Trainer (String name){
        this.name = name;
        this.badges = 0;
        this.pokemonList = new ArrayList<>();
    }

    public List<Pokemon> getPokemonList() {
        return this.pokemonList;
    }

    public String getName() {
        return this.name;
    }

    public void setBadges(int badges) {
        this.badges = badges;
    }

    public int getBadges() {
        return this.badges;
    }
}
