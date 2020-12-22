import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Voina {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<Integer> firstDeck = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)//връща примитивен тип int поток
                .boxed()//затова го опраковаме в Stream<Integer> (рапър класа)
                .collect(Collectors.toCollection(LinkedHashSet::new));
        Set<Integer> secondDeck = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)//така просто ги прави на int
                .collect(Collectors.toCollection(LinkedHashSet::new));

        int round = 1;
        while (round <= 50 || firstDeck.isEmpty() || secondDeck.isEmpty()){
            //Така взимаме първият елемент от Set-а
            Integer cardFirstDeck = firstDeck.iterator().next();
            firstDeck.remove(cardFirstDeck);//и след това го премахваме
            Integer cardSecondDeck = secondDeck.iterator().next();
            secondDeck.remove(cardSecondDeck);

            if (cardFirstDeck > cardSecondDeck){
                firstDeck.add(cardFirstDeck);
                firstDeck.add(cardSecondDeck);
            } else {
                secondDeck.add(cardSecondDeck);
                secondDeck.add(cardFirstDeck);
            }
            round++;
        }
        if (firstDeck.size() > secondDeck.size()){
            System.out.println("First player win!");
        } else if (secondDeck.size() > firstDeck.size()){
            System.out.println("Second player win!");
        } else {
            System.out.println("Draw!");
        }
    }
}
