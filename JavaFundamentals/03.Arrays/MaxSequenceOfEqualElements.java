import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MaxSequenceOfEqualElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] array = scanner.nextLine().split(" ");
        List<String> result = new ArrayList<>();

        for (int i = 0; i < array.length; i++) {
            List<String> tokens = new ArrayList<>();
            tokens.add(array[i]);
            for (int j = i + 1; j < array.length; j++) {
                if (array[i].equals(array[j])){
                    tokens.add(array[i]);
                } else {
                    break;
                }
            }
            if (tokens.size() > result.size()){
                result.removeAll(result);
                result.addAll(tokens);
            }
        }
        for (String element:result) {
            System.out.print(element + " ");
        }
    }
}
