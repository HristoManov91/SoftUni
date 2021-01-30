import java.util.*;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Exercise_10_PredicateParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> guests = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());

        String input = scanner.nextLine();
        while (!input.equals("Party!")){
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            String criteria1 = tokens[1];
            String criteria2 = tokens[2];

            Predicate<String> predicate = createPredicateToRemove(criteria1 , criteria2);

            switch (command){
                case "Remove":
//                    predicate = createPredicateToRemove(criteria1 , criteria2);
                    guests = guests.stream().filter(predicate).collect(Collectors.toList());
                    System.out.println();
                    break;
                case "Double":
//                    predicate = createPredicateToDouble(criteria1 , criteria2);
                    List<String> guestToDouble = new ArrayList<>();
                    for (String guest : guests) {
                        if (!predicate.test(guest)){
                            guestToDouble.add(guest);
                        }
                    }
                    guests.addAll(guestToDouble);
                    break;
            }
            input = scanner.nextLine();
        }
        Collections.sort(guests);
        System.out.println(guests.isEmpty()
                        ? "Nobody is going to the party!"
                        : String.join(", ", guests) + " are going to the party!");
    }

//    private static Predicate<String> createPredicateToDouble(String criteria1, String criteria2) {
//        Predicate<String> predicate = null;
//        switch (criteria1){
//            case "StartsWith":
//                predicate =  name -> name.startsWith(criteria2);
//                break;
//            case "EndsWith":
//                predicate =  name -> name.endsWith(criteria2);
//                break;
//            case "Length":
//                int length = Integer.parseInt(criteria2);
//                predicate =  name -> name.length() == length;
//                break;
//        }
//        return predicate;
//    }

    private static Predicate<String> createPredicateToRemove(String criteria1, String criteria2) {
        Predicate<String> predicate = null;
        switch (criteria1){
            case "StartsWith":
                predicate =  name -> !name.startsWith(criteria2);
                break;
            case "EndsWith":
                predicate =  name -> !name.endsWith(criteria2);
                break;
            case "Length":
                int length = Integer.parseInt(criteria2);
                predicate =  name -> name.length() != length;
                break;
        }
        return predicate;
    }
}
