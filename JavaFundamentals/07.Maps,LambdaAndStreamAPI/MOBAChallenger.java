import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MOBAChallenger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String , Map<String , Integer>> playerPool = new HashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("Season end")){
            String delimiter = "";
            if (input.contains("->")){
                delimiter = "\\s+->\\s+";
            } else {
                delimiter = "\\s+vs\\s+";
            }
            String[] tokens = input.split(delimiter);
            switch (delimiter){
                case "\\s+->\\s+":
                    String playerName = tokens[0];
                    String position = tokens[1];
                    int skill = Integer.parseInt(tokens[2]);
                    playerPool.putIfAbsent(playerName , new LinkedHashMap<>());
                    playerPool.get(playerName).putIfAbsent(position , 0);
                    if (playerPool.get(playerName).get(position) < skill){
                        playerPool.get(playerName).put(position , skill);
                    }
                    break;
                case "\\s+vs\\s+":
                    String firstPlayer = tokens[0];
                    String secondPlayer = tokens[1];
                    if (playerPool.containsKey(firstPlayer) && playerPool.containsKey(secondPlayer)){
                        String playerToRemove = "";
                        for (Map.Entry<String , Integer> current: playerPool.get(firstPlayer).entrySet()){
                            for (Map.Entry<String, Integer> current2: playerPool.get(secondPlayer).entrySet()){
                                if (current.getKey().equals(current2.getKey())){
                                    int firstPlayerTotalSkill = playerPool.get(firstPlayer)
                                            .values().stream().mapToInt(e -> e).sum();
                                    int secondPlayerTotalSkill = playerPool.get(secondPlayer)
                                            .values().stream().mapToInt(e -> e).sum();
                                    if (firstPlayerTotalSkill > secondPlayerTotalSkill){
                                        playerToRemove = secondPlayer;
                                    } else if (secondPlayerTotalSkill > firstPlayerTotalSkill){
                                        playerToRemove = firstPlayer;
                                    }
                                }
                            }
                        }
                        playerPool.remove(playerToRemove);
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        playerPool
                .entrySet()
                .stream()
                .sorted((p1,p2) ->{
                    int p1Result = p1.getValue().values().stream().mapToInt(e -> e).sum();
                    int p2Result = p2.getValue().values().stream().mapToInt(e -> e).sum();
                    int result = Integer.compare(p2Result , p1Result);
                    if (result == 0){
                        result = p1.getKey().compareTo(p2.getKey());
                    }
                    return result;
                })
                .forEach(p -> {
                    System.out.printf("%s: %d skill%n", p.getKey() ,
                            p.getValue().values().stream().mapToInt(e -> e).sum());
                    p.getValue()
                            .entrySet()
                            .stream()
                            .sorted((s1,s2) -> {
                                int result = s2.getValue().compareTo(s1.getValue());
                                if (result == 0){
                                    result = s1.getKey().compareTo(s2.getKey());
                                }
                                return result;
                            })
                            .forEach(ps -> System.out.printf("- %s <::> %d%n", ps.getKey() , ps.getValue()));
                });
    }
}
