import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MergingLists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> first = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());
        List<String> second = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());
        List<String> result = new ArrayList<>();

        if (first.size() >= second.size()){
            for (int i = 0; i < first.size(); i++) {
                result.add(first.get(i));
                if (i <= second.size() - 1){
                    result.add(second.get(i));
                }
            }
        } else {
            for (int i = 0; i < second.size(); i++) {
                if (i <= first.size() - 1){
                    result.add(first.get(i));
                }
                result.add(second.get(i));
            }
        }
        for (String element : result) {
            System.out.print(element + " ");
        }
    }
}
