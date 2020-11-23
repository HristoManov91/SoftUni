import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> numbers = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());
        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            switch (command) {
                case "Add":
                    String numberToAdd = tokens[1];
                    numbers.add(numberToAdd);
                    break;
                case "Insert":
                    String numberToInsert = tokens[1];
                    int index = Integer.parseInt(tokens[2]);
                    if (0 <= index && index < numbers.size()) {
                        numbers.add(index, numberToInsert);
                    } else {
                        System.out.println("Invalid index");
                    }
                    break;
                case "Remove":
                    int indexToRemove = Integer.parseInt(tokens[1]);
                    if (0 <= indexToRemove && indexToRemove < numbers.size()) {
                        numbers.remove(indexToRemove);
                    } else {
                        System.out.println("Invalid index");
                    }
                    break;
                case "Shift":
                    String secondCommand = tokens[1];
                    int count = Integer.parseInt(tokens[2]);
                    if (secondCommand.equals("left")) {
                        for (int i = 0; i < count; i++) {
                            String temp = numbers.get(0);
                            for (int j = 0; j < numbers.size() - 1; j++) {
                                numbers.set(j, numbers.get(j + 1));
                            }
                            numbers.set(numbers.size() - 1, temp);
                        }
                    } else if (secondCommand.equals("right")) {
                        for (int i = 0; i < count; i++) {
                            String temp = numbers.get(numbers.size() - 1);
                            for (int j = numbers.size() - 1; j >= 1; j--) {
                                numbers.set(j, numbers.get(j - 1));
                            }
                            numbers.set(0, temp);
                        }
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.println(numbers.toString().replaceAll("[\\[\\],]", ""));
    }
}
