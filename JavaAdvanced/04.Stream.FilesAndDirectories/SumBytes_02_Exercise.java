import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.stream.Collectors;

public class SumBytes_02_Exercise {
    public static void main(String[] args) throws FileNotFoundException {
        String inputPath = "D:\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        BufferedReader reader = new BufferedReader(new FileReader(inputPath));

        List<String> rows = reader.lines().collect(Collectors.toUnmodifiableList());

        int sumOfCharacters = 0;
        for (String row : rows) {
            char[] arr = row.toCharArray();
            for (char c : arr) {
                sumOfCharacters += c;
            }
        }
        System.out.println(sumOfCharacters);
    }
}
