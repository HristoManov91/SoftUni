import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class SumOfLines_01_Exercise {
    public static void main(String[] args) throws FileNotFoundException {
        String inputPath = "D:\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(inputPath))){
            List<String> rows = reader.lines().collect(Collectors.toUnmodifiableList());
            for (String row : rows) {
                int sum = 0;
                char[] arr = row.toCharArray();
                for (char c : arr) {
                    sum += c;
                }
                System.out.println(sum);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
