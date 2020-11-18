import java.util.Arrays;
import java.util.Scanner;

public class SumOfEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .filter(n -> n % 2 == 0)
                .sum();

        System.out.println(sum);
    }
}
