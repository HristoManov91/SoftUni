import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationBasics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> numbers = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());

        String input = scanner.nextLine();
        while (!input.equals("end")){
            String[] inputArray = input.split(" ");
            String command = inputArray[0];
            switch (command){
                case "Add":
                    String numberToAdd = inputArray[1];
                    numbers.add(numberToAdd);
                    break;
                case "Remove":
                    String numberToRemove = inputArray[1];
                    numbers.remove(numberToRemove);
                    break;
                case "RemoveAt":
                    int removeNumberToGivenIndex = Integer.parseInt(inputArray[1]);
                    numbers.remove(removeNumberToGivenIndex);
                    break;
                case "Insert":
                    String numberToInsert = inputArray[1];
                    int indexToInsert = Integer.parseInt(inputArray[2]);
                    numbers.add(indexToInsert , numberToInsert);
                    break;

            }
            input = scanner.nextLine();
        }
        for (String element : numbers) {
            System.out.print(element + " ");
        }
    }
}
