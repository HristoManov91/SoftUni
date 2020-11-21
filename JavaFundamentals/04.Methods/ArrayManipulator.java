import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ArrayManipulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        String input = scanner.nextLine();
        while (!input.equals("end")) {
            String[] command = input.split(" ");
            String typeNum = "";
            switch (command[0]) {
                case "exchange":
                    int index = Integer.parseInt(command[1]);
                    if (0 <= index && index < numbers.length) {
                        numbers = exchangeFromIndex(index, numbers);
                    } else {
                        System.out.println("Invalid index");
                    }
                    break;
                case "max":
                    typeNum = command[1];
                    if (typeNum.equals("even")) {
                        indexMaxEven(numbers);
                    } else if (typeNum.equals("odd")) {
                      indexMaxOdd(numbers);
                    }
                    break;
                case "min":
                    typeNum = command[1];
                    if (typeNum.equals("even")) {
                        indexMinEven(numbers);
                    } else if (typeNum.equals("odd")){
                        indexMinOdd(numbers);
                    }
                    break;
                case "first":
                    int firstCount = Integer.parseInt(command[1]);
                    if (firstCount > numbers.length){
                        System.out.println("Invalid count");
                        break;
                    }
                    typeNum = command[2];
                    if (typeNum.equals("even")){
                        firstEven(numbers , firstCount);
                    } else if (typeNum.equals("odd")){
                        firstOdd(numbers , firstCount);
                    }
                    break;
                case "last":
                    int lastCount = Integer.parseInt(command[1]);
                    if (lastCount > numbers.length ){
                        System.out.println("Invalid count");
                        break;
                    }
                    typeNum = command[2];
                    if (typeNum.equals("even")){
                        lastEven(numbers , lastCount);
                    } else if (typeNum.equals("odd")){
                        lastOdd(numbers , lastCount);
                    }
                    break;

            }
            input = scanner.nextLine();
        }
        List<Integer> result = Arrays.stream(numbers).boxed().collect(Collectors.toList());
        System.out.println(result);
    }

    static int[] exchangeFromIndex(int index, int[] numbers) {
        int[] output = new int[numbers.length];
        int indexNewArray = 0;
        for (int i = index + 1 ; i < numbers.length; i++) {
            output[indexNewArray] = numbers[i];
            indexNewArray++;
        }
        for (int i = 0; i <= index; i++) {
            output[indexNewArray] = numbers[i];
            indexNewArray++;
        }
        return output;
    }

    static void indexMaxEven( int[] numbers){
        int maxEven = Integer.MIN_VALUE;
        int indexMaxEven = -1;
        for (int i = 0; i < numbers.length; i++) {
            int number = numbers[i];
            if (number % 2 == 0 && number >= maxEven){
                maxEven = number;
                indexMaxEven = i;
            }
        }
        if (indexMaxEven == -1){
            System.out.println("No matches");
        } else {
            System.out.println(indexMaxEven);
        }
    }

    static void indexMaxOdd (int[] numbers){
        int maxOdd = Integer.MIN_VALUE;
        int indexMaxOdd = -1;
        for (int i = 0; i < numbers.length; i++) {
            int number = numbers[i];
            if (number % 2 == 1 && number >= maxOdd){
                maxOdd = number;
                indexMaxOdd = i;
            }
        }
        if (indexMaxOdd == -1){
            System.out.println("No matches");
        } else {
            System.out.println(indexMaxOdd);
        }
    }

    static void indexMinOdd (int[] numbers){
        int minOdd = Integer.MAX_VALUE;
        int indexMinOdd = -1;
        for (int i = 0; i < numbers.length; i++) {
            int number = numbers[i];
            if (number % 2 == 1 && number <= minOdd){
                minOdd = number;
                indexMinOdd = i;
            }
        }
        if (indexMinOdd == -1){
            System.out.println("No matches");
        } else {
            System.out.println(indexMinOdd);
        }
    }

    static void indexMinEven (int[] numbers){
        int minEven = Integer.MAX_VALUE;
        int indexMinEven = -1;
        for (int i = 0; i < numbers.length; i++) {
            int number = numbers[i];
            if (number % 2 == 0 && number <= minEven){
                minEven = number;
                indexMinEven = i;
            }
        }
        if (indexMinEven == -1){
            System.out.println("No matches");
        } else {
            System.out.println(indexMinEven);
        }
    }

    static void firstEven (int[] numbers , int count){
        List<Integer> output = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0){
                output.add(numbers[i]);
                if (count == output.size()){
                    break;
                }
            }
        }
        System.out.println(output);
    }

    static void firstOdd (int[] numbers , int count){
        List<Integer> output = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 1){
                output.add(numbers[i]);
                if (count == output.size()){
                    break;
                }
            }
        }
        System.out.println(output);
    }

    static void lastEven (int[] numbers , int count){
        List<Integer> output = new ArrayList<>();
        for (int i = numbers.length - 1; i >= 0; i--) {
            if (numbers[i] % 2 == 0){
                output.add(0 , numbers[i]);
                if (count == output.size()){
                    break;
                }
            }
        }
        System.out.println(output);
    }

    static void lastOdd (int[] numbers , int count){
        List<Integer> output = new ArrayList<>();
        for (int i = numbers.length - 1; i >= 0; i--) {
            if (numbers[i] % 2 == 1){
                output.add(0 , numbers[i]);
                if (count == output.size()){
                    break;
                }
            }
        }
        System.out.println(output);
    }
}
