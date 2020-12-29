package PokemonTrainer;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Trainer> trainerList = new ArrayList<>();
        String input = scanner.nextLine();
        while (!input.equals("Tournament")) {
            String[] tokens = input.split(" ");
            String trainerName = tokens[0];
            String pokemonName = tokens[1];
            String element = tokens[2];
            int health = Integer.parseInt(tokens[3]);
            Pokemon pokemon = new Pokemon(pokemonName, element, health);

            boolean containsTrainer = false;
            for (Trainer value : trainerList) {
                if (value.getName().equals(trainerName)) {
                    value.getPokemonList().add(pokemon);
                    containsTrainer = true;
                    break;
                }
            }
            if (!containsTrainer) {
                Trainer trainer = new Trainer(trainerName);
                trainer.getPokemonList().add(pokemon);
                trainerList.add(trainer);
            }

            input = scanner.nextLine();
        }

        input = scanner.nextLine();
        while (!input.equals("End")) {
            boolean containsElement;
            switch (input) {
                case "Fire":
                case "Water":
                case "Electricity":
                    for (Trainer trainer : trainerList) {
                        containsElement = containsElement(input, trainer);
                        if (!containsElement) {
                            removeHealth(trainer);
                        }
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        trainerList.stream()
                .sorted((t1 , t2) -> Integer.compare(t2.getBadges(), t1.getBadges()))
                .forEach(t -> System.out.println(t.getName() + " " + t.getBadges() + " " + t.getPokemonList().size()));
    }

    private static void removeHealth(Trainer trainer) {
        List<Pokemon> pokemonsToRemove = new ArrayList<>();
        for (Pokemon pokemon : trainer.getPokemonList()) {
            if (pokemon.getHealth() <= 10){
                pokemonsToRemove.add(pokemon);
            } else {
                pokemon.setHealth(pokemon.getHealth() - 10);
            }
        }
        for (Pokemon pokemonToRemove: pokemonsToRemove) {
            trainer.getPokemonList().remove(pokemonToRemove);
        }
    }

    private static boolean containsElement(String element, Trainer trainer) {

        boolean isContainsElement = false;
        List<Pokemon> pokemonList = trainer.getPokemonList();
        for (Pokemon pokemon : pokemonList) {
            if (pokemon.getElement().equals(element)) {
                isContainsElement = true;
                trainer.setBadges(trainer.getBadges() + 1);
                break;
            }
        }
        return isContainsElement;
    }
}
