import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Lab_05_FilterByAge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());

        Map<String , Integer> persons = new LinkedHashMap<>();
        for (int i = 0; i < count; i++) {
            String[] tokens = scanner.nextLine().split(", ");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);
            persons.put(name , age);
        }

        String condition = scanner.nextLine();
        int ageForCondition = Integer.parseInt(scanner.nextLine());
        Predicate<Integer> isValidPerson = createPredicate(condition , ageForCondition);

        String format = scanner.nextLine();
        Consumer<Map.Entry<String , Integer>> printerFormat = createFormat(format);

        persons.entrySet().stream().filter(p -> isValidPerson.test(p.getValue())).forEach(printerFormat);

    }

    private static Consumer<Map.Entry<String, Integer>> createFormat(String format) {
        Consumer<Map.Entry<String , Integer>> consumer = null;
        if (format.equals("age")){
            consumer = p -> System.out.printf("%d%n", p.getValue());
        } else if (format.equals("name")){
            consumer = p -> System.out.printf("%s%n", p.getKey());
        } else {
            consumer = p -> System.out.printf("%s - %d%n", p.getKey() , p.getValue());
        }
        return consumer;
    }

    public static Predicate<Integer> createPredicate (String condition , int age){
        Predicate<Integer> test = null;
        if (condition.equals("younger")){
            test = a -> a <= age;
        } else {
            test = a -> a >= age;
        }
        return test;
    }
}
