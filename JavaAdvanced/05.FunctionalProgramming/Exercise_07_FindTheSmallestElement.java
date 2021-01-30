import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Exercise_07_FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        Function<List<Integer> , Integer> indexSmallestElement = list -> {
            int indexSmallElement = -1;
            int minElement = Integer.MAX_VALUE;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) <= minElement){
                    indexSmallElement = i;
                    minElement = list.get(i);
                }
            }
            return indexSmallElement;
        };

        System.out.println(indexSmallestElement.apply(numbers));
    }
}
