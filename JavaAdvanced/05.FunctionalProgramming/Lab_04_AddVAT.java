import java.util.Arrays;
import java.util.Scanner;
import java.util.function.UnaryOperator;

public class Lab_04_AddVAT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UnaryOperator<Double> addVAT = n -> n * 1.20;

        System.out.println("Prices with VAT:");
        Arrays.stream(scanner.nextLine().split(", "))
                .map(Double::parseDouble)
                .map(addVAT)
                .forEach(n -> System.out.printf("%.2f%n", n));
    }
}
