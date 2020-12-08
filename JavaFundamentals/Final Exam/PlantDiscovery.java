import java.util.*;

public class PlantDiscovery2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String , Integer> plantRarity = new HashMap<>();
        Map<String , List<Double>> plantRatings = new HashMap<>();
        int countPlant = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < countPlant; i++) {
            String[] nameAndRarity = scanner.nextLine().split("<->");
            plantRarity.put(nameAndRarity[0] , Integer.parseInt(nameAndRarity[1]));
        }

        String input = scanner.nextLine();
        while (!input.equals("Exhibition")){
            String[] commandAndParameters = input.split(": ");

            switch (commandAndParameters[0]){
                case "Rate":
                    String[] rateParameters = commandAndParameters[1].split(" - ");
                    String ratePlantName = rateParameters[0];
                    if (plantRarity.containsKey(ratePlantName)) {
                        double rating = Double.parseDouble(rateParameters[1]);

                        plantRatings.putIfAbsent(ratePlantName, new ArrayList<>());
                        plantRatings.get(ratePlantName).add(rating);
                    } else {
                        System.out.println("error");
                    }
                    break;
                case "Update":
                    String[] rarityNewParameters = commandAndParameters[1].split(" - ");
                    if ( plantRarity.containsKey(rarityNewParameters[0])) {
                        plantRarity.put(rarityNewParameters[0], Integer.parseInt(rarityNewParameters[1]));
                    } else {
                        System.out.println("error");
                    }
                    break;
                case "Reset":
                    String plantToReset = commandAndParameters[1];
                    if ( plantRatings.containsKey(plantToReset)){
                        plantRatings.get(plantToReset).clear();
                    } else {
                        System.out.println("error");
                    }
                    break;
                default:
                    System.out.println("error");
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.println("Plants for the exhibition:");
        plantRarity
                .entrySet()
                .stream()
                .sorted((a , b) -> {
                    int result = b.getValue().compareTo(a.getValue());
                    if (result == 0){
                        double aRatings = getAverageRatings(plantRatings.get(a.getKey()));
                        double bRatings = getAverageRatings(plantRatings.get(b.getKey()));
                        result = Double.compare(bRatings , aRatings);
                    }
                    return result;
                })
                .forEach(p -> {
                    List<Double> pRatings = plantRatings.get(p.getKey());
                    double pAverageRatings;
                    if (pRatings != null) {
                        pAverageRatings = getAverageRatings(pRatings);
                    } else {
                        pAverageRatings = 0.0;
                    }
                    System.out.printf("- %s; Rarity: %d; Rating: %.2f%n", p.getKey() , p.getValue() , pAverageRatings);
                });
    }
    static double getAverageRatings (List<Double> ratings){
        if (ratings.isEmpty()){
            return 0.0;
        }
        double sum = 0;
        for (Double num : ratings) {
            sum += num;
        }
        return sum / ratings.size();
    }
}
