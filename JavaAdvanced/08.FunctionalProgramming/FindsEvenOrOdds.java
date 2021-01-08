import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class FindsEvenOrOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] boundaries = scanner.nextLine().split(" ");
        int downBound = Integer.parseInt(boundaries[0]);
        int upBound = Integer.parseInt(boundaries[1]);

        List<Integer> numbers = new ArrayList<>();
        for (int i = downBound; i <= upBound; i++) {
            numbers.add(i);
        }
        Predicate<Integer> odd = num -> num % 2 == 1 || num % 2 == -1;
        Predicate<Integer> even = num -> num % 2 == 0;

        String command = scanner.nextLine();
        switch (command){
            case "odd":
                numbers.stream().filter(odd).forEach(num -> System.out.print(num + " "));
                break;
            case "even":
                numbers.stream().filter(even).forEach(num -> System.out.print(num + " "));
                break;
        }
    }
}
