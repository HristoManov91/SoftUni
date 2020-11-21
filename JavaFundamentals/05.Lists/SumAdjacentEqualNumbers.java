import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SumAdjacentEqualNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Double> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Double::parseDouble)
                .collect(Collectors.toList());

        for (int i = 0; i < numbers.size() - 1; i++) {
            if (numbers.get(i).equals(numbers.get(i + 1))){
                double number = numbers.get(i) + numbers.get(i + 1);
                numbers.set(i , number);
                numbers.remove(i + 1);
                i = -1;
            }
        }
        DecimalFormat df = new DecimalFormat("0.#");
        for (Double num: numbers) {
            System.out.print(df.format(num) + " ");
        }
    }
}
