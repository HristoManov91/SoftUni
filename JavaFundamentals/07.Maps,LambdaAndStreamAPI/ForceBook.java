import java.util.*;

public class ForceBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<String>> forceBook = new TreeMap<>();

        String input = scanner.nextLine();
        while (!input.equals("Lumpawaroo")) {
            String[] tokens;
            String delimiter = "";
            if (input.contains("|")){
                delimiter = "|";
                tokens = input.split("\\s+\\|\\s+");
            } else {
                delimiter = "->";
                tokens = input.split("\\s+->\\s+");
            }
            String forceSide = "";
            String user = "";
            switch (delimiter) {
                case "|":
                    forceSide = tokens[0];
                    user = tokens[1];
                    boolean check = false;
                    for (Map.Entry<String, List<String>> side : forceBook.entrySet()) {
                        if (side.getValue().contains(user)) {
                            check = true;
                            break;
                        }
                    }

                    if (!check) {
                        forceBook.putIfAbsent(forceSide, new ArrayList<>());
                        forceBook.get(forceSide).add(user);
                    }
                    break;
                case "->":
                    user = tokens[0];
                    forceSide = tokens[1];
                    for (Map.Entry<String, List<String>> current : forceBook.entrySet()) {
                        current.getValue().remove(user);
                    }
                    forceBook.putIfAbsent(forceSide, new ArrayList<>());
                    forceBook.get(forceSide).add(user);
                    System.out.printf("%s joins the %s side!%n", user , forceSide);
                    break;
            }
            input = scanner.nextLine();
        }
        forceBook
                .entrySet()
                .stream()
                .filter(f -> f.getValue().size() > 0)
                .sorted((f1,f2) -> {
                    int result = Integer.compare(f2.getValue().size() , f1.getValue().size());
                    if (result == 0){
                        result = f1.getKey().compareTo(f2.getKey());
                    }
                    return result;
                })
                .forEach(f -> {
                    System.out.printf("Side: %s, Members: %d%n", f.getKey(), f.getValue().size());
                    f.getValue()
                            .stream()
                            .sorted()
                            .forEach(n -> System.out.printf("! %s%n", n));
                });
    }
}
