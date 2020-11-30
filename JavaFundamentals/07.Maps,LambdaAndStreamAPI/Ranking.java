import java.util.*;

public class Ranking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String , String> contestValidation = new HashMap<>();

        String input = scanner.nextLine();
        while (!"end of contests".equals(input)){
            String[] tokens = input.split(":");
            String contest = tokens[0];
            String password = tokens[1];
            contestValidation.putIfAbsent(contest , password);

            input = scanner.nextLine();
        }
        Map<String , Map<String , Integer>> studentResult = new TreeMap<>();
        String input2 = scanner.nextLine();
        while (!"end of submissions".equals(input2)){
            String[] tokens = input2.split("=>");
            String contest = tokens[0];
            String password = tokens[1];
            String username = tokens[2];
            int points = Integer.parseInt(tokens[3]);
            for (Map.Entry<String, String> current: contestValidation.entrySet()){
                if (current.getKey().equals(contest) && current.getValue().equals(password)){
                    studentResult.putIfAbsent(username , new LinkedHashMap<>());
                    if (studentResult.get(username).containsKey(contest)){
                        if (studentResult.get(username).get(contest) < points){
                            studentResult.get(username).put(contest , points);
                            break;
                        }
                    } else {
                        studentResult.get(username).put(contest , points);
                        break;
                    }
                }
            }
            input2 = scanner.nextLine();
        }
        String bestCandidate = "";
        int totalBestPoints = 0;
        for (Map.Entry<String, Map<String, Integer>> current : studentResult.entrySet()){
            int currentPoints = current.getValue().values().stream().mapToInt(e -> e).sum();
            if ( currentPoints > totalBestPoints){
                totalBestPoints = currentPoints;
                bestCandidate = current.getKey();
            }
        }
        System.out.printf("Best candidate is %s with total %d points.%n", bestCandidate , totalBestPoints);
        System.out.println("Ranking: ");
        studentResult
                .entrySet()
                .stream()
                .forEach(s -> {
                    System.out.println(s.getKey());
                    s.getValue()
                            .entrySet()
                            .stream()
                            .sorted((p1,p2) -> p2.getValue().compareTo(p1.getValue()))
                            .forEach(c -> System.out.println("#  " + c.getKey() + " -> " + c.getValue()));
                });
    }
}
