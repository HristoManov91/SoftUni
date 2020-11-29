import java.util.*;

public class Courses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<String>> coursesInformation = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("end")) {
            String[] tokens = input.split(" : ");
            String course = tokens[0];
            String studentName = tokens[1];

            coursesInformation.putIfAbsent(course, new ArrayList<>());
            coursesInformation.get(course).add(studentName);

            input = scanner.nextLine();
        }
        coursesInformation
                .entrySet()
                .stream()
                //сортираме ги по размер на стойност,понеже .size връща малък int се сортира с метода за сортиране на
                //Integer.compare(f , s);
                .sorted((f, s) -> Integer.compare(s.getValue().size(), f.getValue().size()))
                .forEach(c -> {
                    //принтираме първо курса
                            System.out.printf("%s: %d%n", c.getKey(), c.getValue().size());
                            //а след това пускаме stream с елементите в стойноста(листа)
                            c.getValue()
                                    .stream()
                                    .sorted()
                                    .forEach(s -> System.out.printf("-- %s%n", s));
                        }
                );
    }
}
