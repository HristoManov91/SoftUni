import java.util.*;
import java.util.stream.Collectors;

public class Bombs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> bombEffects  = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> bombCasings = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .forEach(bombCasings::push);

        //•	Datura Bombs: 40
        //•	Cherry Bombs: 60
        //•	Smoke Decoy Bombs: 120
        Map<String , Integer> bombs = new TreeMap<>();
        bombs.put("Datura Bombs" , 0);
        bombs.put("Cherry Bombs" , 0);
        bombs.put("Smoke Decoy Bombs" , 0);

        while (!bombEffects.isEmpty() && !bombCasings.isEmpty() && !fillBombPouch(bombs.values())){
            int currentBombEffect = bombEffects.poll();
            int currentBombCasing = bombCasings.pop();
            int sum = currentBombCasing + currentBombEffect;

            while (sum != 40 && sum != 60 && sum != 120){
                sum -= 5;
            }

            switch (sum){
                case 40:
                    bombs.put("Datura Bombs" , bombs.get("Datura Bombs") + 1);
                    break;
                case 60:
                    bombs.put("Cherry Bombs", bombs.get("Cherry Bombs") + 1);
                    break;
                case 120:
                    bombs.put("Smoke Decoy Bombs" ,bombs.get("Smoke Decoy Bombs") + 1);
                    break;
            }
        }
        System.out.println(fillBombPouch(bombs.values())
                ? "Bene! You have successfully filled the bomb pouch!"
                : "You don't have enough materials to fill the bomb pouch.");

        System.out.println("Bomb Effects: " + getElementInfo(bombEffects));

        System.out.println("Bomb Casings: " + getElementInfo(bombCasings));

        bombs.forEach((key, value) -> System.out.println(key + ": " + value));
    }

    private static boolean fillBombPouch(Collection<Integer> values){
        for (Integer value : values) {
            if (value < 3){
                return false;
            }
        }
        return true;
    }

    private static String getElementInfo(ArrayDeque<Integer> deque){
         return deque.isEmpty()
                ? "empty"
                : deque.stream().map(String::valueOf).collect(Collectors.joining(", "));
    }
}
