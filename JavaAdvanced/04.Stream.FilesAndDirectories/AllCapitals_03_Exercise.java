import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;

public class AllCapitals_03_Exercise {
    public static void main(String[] args) throws FileNotFoundException {
        String inputPath = "D:\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        BufferedReader reader = new BufferedReader(new FileReader(inputPath));

        PrintWriter writer = new PrintWriter("D:\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt");

        List<String> rows = reader.lines().collect(Collectors.toUnmodifiableList());

        for (String row : rows) {
            writer.write(row.toUpperCase());
            writer.write(System.lineSeparator());
        }
        writer.close();
    }
}
