import java.util.*;

public class CitiesByContinentAndCounty_07_Lab {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Map<String, List<String>>> continentsInformation = new LinkedHashMap<>();

        int count = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < count; i++) {
            String[] input = scanner.nextLine().split(" ");
            String continent = input[0];
            String country = input[1];
            String city = input[2];

            continentsInformation.putIfAbsent(continent, new LinkedHashMap<>());
            continentsInformation.get(continent).putIfAbsent(country, new ArrayList<>());
            continentsInformation.get(continent).get(country).add(city);
        }
        continentsInformation.entrySet().stream()
                .forEach(con -> {
                    System.out.println(con.getKey() + ":");
                    con.getValue().entrySet()
                            .forEach(c -> {
                                System.out.println(" " + c.getKey() + " -> " + String.join(", ", c.getValue()));
                            });
                });

//        continentsInformation
//                .forEach((key, value) -> {
//                    System.out.println(key + ":");
//                    value.forEach((innerKey, innerValue) -> {
//                        System.out.println(innerKey + " -> "
//                                + String.join(", ", innerValue));
//                    });
//                });
    }
}
