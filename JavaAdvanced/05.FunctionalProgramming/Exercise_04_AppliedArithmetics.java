import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Exercise_04_AppliedArithmetics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        String command = scanner.nextLine();
        while (!command.equals("end")){
            if (command.equals("print")){
                for (int number : numbers) {
                    System.out.print(number + " ");
                }
            } else {
                Function<Integer , Integer> function = createConsumer(command);
                for (int i = 0; i < numbers.size(); i++) {
                    numbers.set(i , function.apply(numbers.get(i)));
                }
            }
            command = scanner.nextLine();
        }
    }

    private static Function<Integer , Integer> createConsumer(String command) {
        Function<Integer , Integer> function = null;
        switch (command){
            case "add":
                function = n -> n + 1;
                break;
            case "multiply":
                function = n -> n * 2;
                break;
            case "subtract":
                function = n -> n - 1;
                break;
        }
        return function;
    }
}
