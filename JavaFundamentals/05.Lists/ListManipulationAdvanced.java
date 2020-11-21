import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationAdvanced {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String input = scanner.nextLine();
        while (!input.equals("end")) {
            String[] tokens = input.split(" ");
            String command = tokens[0];
            switch (command) {
                case "Contains":
                    int numberToContains = Integer.parseInt(tokens[1]);
                    if (numbers.contains(numberToContains)) {
                        System.out.println("Yes");
                    } else {
                        System.out.println("No such number");
                    }
                    break;
                case "Print":
                    if (tokens[1].equals("even")) {
                        printEvenNumbers(numbers);
                    } else {
                        printOddNumbers(numbers);
                    }
                    break;
                case "Get":
                    printSum(numbers);
                    break;
                case "Filter":
                    String condition = tokens[1];
                    int number = Integer.parseInt(tokens[2]);
                    if (condition.equals("<")) {
                        printAllNumbersLestFromGivenNumber(numbers , number);
                    } else if (condition.equals(">")) {
                        printAllNumbersBiggerFromGivenNumber(numbers , number);
                    } else if (condition.equals("<=")) {
                        printAllLessOrEqualNumbers(numbers , number);
                    } else if (condition.equals(">=")) {
                        printAllBiggerOrEqualsNumbers(numbers , number);
                    }
                    break;
            }
            input = scanner.nextLine();
        }
    }

    private static void printEvenNumbers(List<Integer> numbers) {
        List<Integer> evenNumbers = new ArrayList<>();
        for (Integer number : numbers) {
            if (number % 2 == 0) {
                evenNumbers.add(number);
            }
        }
        System.out.println(evenNumbers.toString().replaceAll("[\\[\\],]", ""));
    }

    private static void printOddNumbers(List<Integer> numbers) {
        List<Integer> oddNumbers = new ArrayList<>();
        for (Integer number : numbers) {
            if (number % 2 == 1) {
                oddNumbers.add(number);
            }
        }
        System.out.println(oddNumbers.toString().replaceAll("[\\[\\],]", ""));
    }

    private static void printSum(List<Integer> numbers) {
        int sumOfNumbers = 0;
        for (int num : numbers) {
            sumOfNumbers += num;
        }
        System.out.println(sumOfNumbers);
    }

    private static void printAllNumbersBiggerFromGivenNumber(List<Integer> numbers, int number) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) > number) {
                result.add(numbers.get(i));
            }
        }
        System.out.println(result.toString().replaceAll("[\\[\\],]", ""));
    }

    private static void printAllNumbersLestFromGivenNumber(List<Integer> numbers, int number) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) < number) {
                result.add(numbers.get(i));
            }
        }
        System.out.println(result.toString().replaceAll("[\\[\\],]", ""));
    }

    private static void printAllBiggerOrEqualsNumbers(List<Integer> numbers, int number) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) >= number) {
                result.add(numbers.get(i));
            }
        }
        System.out.println(result.toString().replaceAll("[\\[\\],]", ""));
    }

    private static void printAllLessOrEqualNumbers(List<Integer> numbers, int number) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) <= number) {
                result.add(numbers.get(i));
            }
        }
        System.out.println(result.toString().replaceAll("[\\[\\],]", ""));
    }
}
