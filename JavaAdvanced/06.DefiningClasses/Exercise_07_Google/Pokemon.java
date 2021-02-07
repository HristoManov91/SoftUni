package Exercise_07_Google;

public class Pokemon {
    private String pokemonName;
    private String pokemonType;

    public Pokemon (String nameOfPokemon , String element){
        this.pokemonName = nameOfPokemon;
        this.pokemonType = element;
    }

    public String getPokemonName() {
        return this.pokemonName;
    }

    public String getPokemonType() {
        return this.pokemonType;
    }
}
