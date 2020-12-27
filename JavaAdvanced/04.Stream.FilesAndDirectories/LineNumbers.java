import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LineNumbers {
    public static void main(String[] args) throws FileNotFoundException {
        BufferedReader reader = new BufferedReader(
                new FileReader("D:\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputLineNumbers.txt"));

        PrintWriter writer = new PrintWriter("D:\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt");

        Stream<String> lines = reader.lines();

        List<String> linesList = lines.collect(Collectors.toList());
        int count = 1;

        for (int i = 0; i < linesList.size(); i++) {
            writer.printf("%d. %s%n", count++ , linesList.get(i));
        }
        writer.close();
    }
}
