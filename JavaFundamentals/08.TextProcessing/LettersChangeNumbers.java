import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");

        List<Double> numbers = new ArrayList<>();

        for (String element : input) {
            char letterBeforeNumber = element.charAt(0);
            char letterAfterNumber = element.charAt(element.length() - 1);
            double number = Double.parseDouble(element.substring(1 , element.length() - 1));
            double result;
            int letterDigit;

            if (Character.isUpperCase(letterBeforeNumber)){
                letterDigit = letterBeforeNumber - 64;
                result = number * 1.0 / letterDigit;
            } else {
                letterDigit = letterBeforeNumber - 96;
                result = number * letterDigit;
            }

            if (Character.isUpperCase(letterAfterNumber)){
                letterDigit = letterAfterNumber - 64;
                result -= letterDigit;
                numbers.add(result);
            } else {
                letterDigit = letterAfterNumber - 96;
                result += letterDigit;
                numbers.add(result);
            }
        }
        double result = numbers.stream().mapToDouble(n -> n).sum();
        System.out.printf("%.2f", result);
    }
}
