import java.util.Arrays;
import java.util.Scanner;

public class ArrayModifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        String input = scanner.nextLine();
        while (!input.equals("end")){
            String[] tokens = input.split(" ");
            String command = tokens[0];
            switch (command){
                case "swap":
                    int firstElement = Integer.parseInt(tokens[1]);
                    int secondElementPosition = Integer.parseInt(tokens[2]);
                    int temp = numbers[firstElement];
                    numbers[firstElement] = numbers[secondElementPosition];
                    numbers[secondElementPosition] = temp;
                    break;
                case "multiply":
                    int firstIndex = Integer.parseInt(tokens[1]);
                    int secondIndex = Integer.parseInt(tokens[2]);
                    int newElement = numbers[firstIndex] * numbers[secondIndex];
                    numbers[firstIndex] = newElement;
                    break;
                case "decrease":
                    for (int i = 0; i < numbers.length; i++) {
                        numbers[i] = numbers[i] - 1;
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.println(Arrays.toString(numbers).replaceAll("[\\[\\]]", ""));
    }
}
