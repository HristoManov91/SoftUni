import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Race {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> participants = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());
        String regexName = "[A-Za-z]+";
        String regexDistance = "\\d";
        Pattern patternName = Pattern.compile(regexName);
        Pattern patternDistance = Pattern.compile(regexDistance);

        Map<String , Integer> result = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("end of race")){
            Matcher matcherName = patternName.matcher(input);
            String name = "";
            while (matcherName.find()){
                name = name.concat(matcherName.group());
            }
            if (participants.contains(name)){
                result.putIfAbsent(name , 0);
                Matcher matcherDistance = patternDistance.matcher(input);
                int distance = 0;
                while (matcherDistance.find()){
                    int number = Integer.parseInt(matcherDistance.group());
                    distance += number;
                }
                result.put(name , result.get(name) + distance);
            }
            input = scanner.nextLine();
        }
        List<String> racers = result
                .entrySet().stream()
                .sorted((r1,r2) -> r2.getValue().compareTo(r1.getValue()))
                .limit(3)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        int count = 1;
        for (String name : racers) {
            switch (count++){
                case 1:
                    System.out.println("1st place: " + name);
                    break;
                case 2:
                    System.out.println("2nd place: " + name);
                    break;
                case 3:
                    System.out.println("3rd place: " + name);
                    break;

            }
        }
    }
}
