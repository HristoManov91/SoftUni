import java.util.*;

public class AverageStudentsGrade_05_Lab {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String , List<Double>> studentsGrade = new TreeMap<>();

        int count = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < count; i++) {
            String[] tokens = scanner.nextLine().split(" ");
            String name = tokens[0];
            double grade = Double.parseDouble(tokens[1]);

            studentsGrade.putIfAbsent(name , new ArrayList<>());
            studentsGrade.get(name).add(grade);
        }

        studentsGrade.entrySet().forEach(s -> {
            double sum = 0;
            for (Double aDouble : s.getValue()) {
                sum += aDouble;
            }
            double average = sum / s.getValue().size();
            System.out.print(s.getKey() + " -> ");
            s.getValue().forEach(g -> System.out.printf("%.2f ", g));
            System.out.printf("(avg: %.2f)%n", average);
        });
    }
}
