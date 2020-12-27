import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AllCapitals {
    public static void main(String[] args) throws FileNotFoundException {
        BufferedReader reader = new BufferedReader(
                new FileReader("D:\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt"));

        PrintWriter writer = new PrintWriter("D:\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt");

        Stream<String> stringStream = reader.lines();

        List<String> listLines = stringStream.collect(Collectors.toList());

        for (String word : listLines) {
            writer.write(word.toUpperCase());
            writer.println();
        }
        writer.close();
    }
}
