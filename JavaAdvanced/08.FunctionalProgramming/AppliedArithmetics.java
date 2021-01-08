import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntUnaryOperator;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class AppliedArithmetics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String command = scanner.nextLine();
        while (!command.equals("end")) {
            Consumer<List<Integer>> com = createConsumer(command);
            com.accept(numbers);
            if (command.equals("print")){
                System.out.println();
            }
            command = scanner.nextLine();
        }
    }

    public static Consumer<List<Integer>> createConsumer(String command) {
        if ("add".equals(command)) {
            return list -> {
                for (int i = 0; i < list.size(); i++) {
                    list.set(i, list.get(i) + 1);
                }
            };
        } else if ("subtract".equals(command)) {
            return list -> {
                for (int i = 0; i < list.size(); i++) {
                    list.set(i, list.get(i) - 1);
                }
            };
        } else if ("multiply".equals(command)) {
            return list -> {
                for (int i = 0; i < list.size(); i++) {
                    list.set(i, list.get(i) * 2);
                }
            };
        } else if ("print".equals(command)){
            return list -> list.forEach(e -> System.out.print(e + " "));
        }
        return null;
    }
}