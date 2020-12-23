import java.util.*;

public class AverageStudentsGrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countStudents = Integer.parseInt(scanner.nextLine());

        Map<String , List<Double>> studentsGrades = new TreeMap<>();
        for (int i = 0; i < countStudents; i++) {
            String[] input = scanner.nextLine().split(" ");
            String student = input[0];
            double grade = Double.parseDouble(input[1]);

            studentsGrades.putIfAbsent(student , new ArrayList<>());
            List<Double> grades = studentsGrades.get(student);
            grades.add(grade);
        }

        studentsGrades
                .entrySet()
                .stream()
                .sorted((s1 , s2) -> s1.getKey().compareTo(s2.getKey()))
                .forEach(s -> {
                    double averageGrade = s.getValue().stream().mapToDouble(Double::doubleValue).average().getAsDouble();
                    System.out.print(s.getKey() + " -> ");
                    s.getValue().stream().forEach(g -> System.out.printf("%.2f ", g));
                    System.out.printf("(avg: %.2f)%n", averageGrade);
                });
    }
}
