import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ChangeList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .collect(Collectors.toList());

        String input = scanner.nextLine();
        while (!input.equals("end")) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            switch (command) {
                case "Insert":
                    String element = tokens[1];
                    int index = Integer.parseInt(tokens[2]);
                    if (index < numbers.size()) {
                        numbers.add(index, element);
                    }
                    break;
                case "Delete":
                    String elementToDeleted = tokens[1];
                    while (numbers.contains(elementToDeleted)) {
                        numbers.remove(elementToDeleted);
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.println(numbers.toString().replaceAll("[\\[\\],]", ""));
    }
}
