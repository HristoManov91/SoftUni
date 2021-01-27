import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;

public class LineNumbers_05_Exercise {
    public static void main(String[] args) throws FileNotFoundException {
        String inputPath = "D:\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputLineNumbers.txt";
        BufferedReader reader = new BufferedReader(new FileReader(inputPath));

        PrintWriter writer =
                new PrintWriter("D:\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt");

        List<String> rows = reader.lines().collect(Collectors.toUnmodifiableList());

        int countRow = 1;
        for (String row : rows) {
            writer.println(countRow + ". " + row);
            countRow++;
        }
        writer.close();
    }
}
