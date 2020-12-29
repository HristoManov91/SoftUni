package PokemonTrainer;

public class Pokemon {
    private String nameOfPokemon;
    private String element;
    private int health;

    public Pokemon (String nameOfPokemon , String element , int health){
        this.nameOfPokemon = nameOfPokemon;
        this.element = element;
        this.health = health;
    }

    public String getElement() {
        return this.element;
    }

    public int getHealth() {
        return this.health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getNameOfPokemon() {
        return this.nameOfPokemon;
    }
}
