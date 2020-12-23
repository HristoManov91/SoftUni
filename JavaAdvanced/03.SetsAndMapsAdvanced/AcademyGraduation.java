import java.util.*;

public class AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countStudents = Integer.parseInt(scanner.nextLine());
        Map<String , Double> studentGrades = new TreeMap<>();

        for (int i = 0; i < countStudents; i++) {
            String student = scanner.nextLine();
            double[] grades = Arrays.stream(scanner.nextLine().split(" ")).mapToDouble(Double::parseDouble).toArray();

            double averageGrade = 0;
            for (Double grade : grades) {
                averageGrade += grade;
            }
            averageGrade = averageGrade / grades.length;
            studentGrades.putIfAbsent(student , averageGrade);
        }
        studentGrades
                .entrySet()
                .forEach(s -> {
                    System.out.println(s.getKey() + " is graduated with " + s.getValue());
                });
    }
}
