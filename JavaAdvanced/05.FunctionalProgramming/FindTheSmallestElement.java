import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Function<List<Integer>, Integer> returnMinElement = list -> {
                int minNumber = Integer.MAX_VALUE;
                int index = -1;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) <= minNumber){
                    minNumber = list.get(i);
                    index = i;
                }
            }
            return index;
        };

        System.out.println(returnMinElement.apply(numbers));
    }
}
