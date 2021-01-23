import java.util.*;
import java.util.stream.Collectors;

public class AcademyGraduation_08_Lab {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());
        Map<String, Double> studentInformation = new TreeMap<>();

        for (int i = 0; i < count; i++) {
            String student = scanner.nextLine();
            List<Double> grades = Arrays.stream(scanner.nextLine().split(" "))
                    .map(Double::parseDouble).collect(Collectors.toList());

            double sum = 0;
            for (Double grade : grades) {
                sum += grade;
            }

            double average = sum / grades.size();

            studentInformation.putIfAbsent(student, average);
        }

        studentInformation
                .entrySet()
                .forEach(s -> {
                    System.out.printf("%s is graduated with %s%n", s.getKey() , s.getValue());
                });
    }
}
