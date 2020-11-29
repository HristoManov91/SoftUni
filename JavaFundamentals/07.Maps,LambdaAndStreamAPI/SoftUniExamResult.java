import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SoftUniExamResult {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> languageSubmission = new HashMap<>();
        Map<String, Integer> studentPoints = new HashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("exam finished")) {
            String[] tokens = input.split("-");
            String username = tokens[0];
            ;
            if ("banned".equals(tokens[1])) {
                studentPoints.remove(username);
            } else {
                String language = tokens[1];
                int points = Integer.parseInt(tokens[2]);
                studentPoints.putIfAbsent(username, 0);
                if (studentPoints.get(username) < points){
                    studentPoints.put(username , points);
                }
                languageSubmission.putIfAbsent(language, 0);
                languageSubmission.put(language, languageSubmission.get(language) + 1);
            }
            input = scanner.nextLine();
        }
        System.out.println("Results:");
        studentPoints
                .entrySet()
                .stream()
                .sorted((s1, s2) -> {
                    int result = s2.getValue().compareTo(s1.getValue());
                    if (result == 0) {
                        result = s1.getKey().compareTo(s2.getKey());
                    }
                    return result;
                })
                .forEach(s -> System.out.println(s.getKey() + " | " + s.getValue()));

        System.out.println("Submissions:");
        languageSubmission
                .entrySet()
                .stream()
                .sorted((s1, s2) -> {
                    int result = s2.getValue().compareTo(s1.getValue());
                    if (result == 0) {
                        result = s1.getKey().compareTo(s2.getKey());
                    }
                    return result;
                })
                .forEach(l -> System.out.println(l.getKey() + " - " + l.getValue()));

    }
}
