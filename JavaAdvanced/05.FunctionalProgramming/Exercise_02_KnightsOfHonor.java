import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class Exercise_02_KnightsOfHonor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Consumer<String> addSir = s -> System.out.println("Sir " + s);

        Arrays.stream(scanner.nextLine().split(" ")).forEach(addSir);
    }
}
