import java.util.*;

public class StudentAcademy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());
        Map<String , List<Double>> studentGrade = new LinkedHashMap<>();

        for (int i = 0; i < count; i++) {
            String nameStudent = scanner.nextLine();
            double gradeStudent = Double.parseDouble(scanner.nextLine());
            studentGrade.putIfAbsent(nameStudent , new ArrayList<>());
            studentGrade.get(nameStudent).add(gradeStudent);
        }
        studentGrade
                .entrySet()
                .stream()
                .filter((s -> s.getValue().stream().mapToDouble(Double::doubleValue).average().getAsDouble() >= 4.50))
                .sorted((s1 , s2)-> {
                    double s1Average = s1.getValue().stream().mapToDouble(Double::doubleValue).average().getAsDouble();
                    double s2Average = s2.getValue().stream().mapToDouble(Double::doubleValue).average().getAsDouble();
                    return Double.compare(s2Average , s1Average);
                })
                .forEach(s -> System.out.println(String.format("%s -> %.2f", s.getKey() ,
                        s.getValue().stream().mapToDouble(Double::doubleValue).average().getAsDouble())));

    }
}
