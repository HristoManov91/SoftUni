import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class AppendArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\|");
        List<String> output = new ArrayList<>();

        for (int i = input.length - 1; i >= 0; i--) {
            List<String> list = Arrays.asList(input[i].split("\\s+").clone());
            output.addAll(list);
            output.remove("");
        }
        StringBuilder sb = new StringBuilder();
        for (String element : output) {
            sb.append(element + " ");
        }
        System.out.println(sb);
    }
}
