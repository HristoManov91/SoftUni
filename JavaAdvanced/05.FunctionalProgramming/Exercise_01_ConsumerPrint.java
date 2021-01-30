import java.util.Arrays;
import java.util.Scanner;

public class Exercise_01_ConsumerPrint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Arrays.stream(scanner.nextLine().split(" ")).forEach(System.out::println);
    }
}
