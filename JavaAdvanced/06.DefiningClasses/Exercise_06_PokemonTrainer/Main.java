package Exercise_06_PokemonTrainer;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Trainer> trainers = new LinkedHashMap<>();
        String input = scanner.nextLine();
        while (!input.equals("Tournament")) {
            String[] tokens = input.split(" ");
            String trainerName = tokens[0];
            if (!trainers.containsKey(trainerName)) {
                trainers.put(trainerName, new Trainer(trainerName));
            }
            String pokemonName = tokens[1];
            String pokemonElement = tokens[2];
            int pokemonHealth = Integer.parseInt(tokens[3]);
            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);
            trainers.get(trainerName).getPokemonList().add(pokemon);

            input = scanner.nextLine();
        }

        input = scanner.nextLine();
        while (!input.equals("End")) {
            for (Trainer trainer : trainers.values()) {
                String finalElement = input;
                long count = trainer.getPokemonList().stream().filter(p -> p.getElement().equals(finalElement)).count();
                if (count > 0) {
                    trainer.setBadges(trainer.getBadges() + 1);
                } else {
                    trainer.getPokemonList().forEach(p -> p.setHealth(p.getHealth() - 10));
                    List<Pokemon> collect = trainer.getPokemonList().stream()
                            .filter(p -> p.getHealth() > 0).collect(Collectors.toList());
                    trainer.setPokemonList(collect);
                }
            }
            input = scanner.nextLine();
        }

        trainers.values().stream()
                .sorted((t1, t2) -> Integer.compare(t2.getBadges(), t1.getBadges()))
                .forEach(t -> System.out.println(t.getName() + " " + t.getBadges() + " " + t.getPokemonList().size()));
    }
}

