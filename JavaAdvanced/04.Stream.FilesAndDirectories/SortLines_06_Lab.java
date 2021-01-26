import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class SortLines_06_Lab {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("D:\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt");

        List<String> rows = Files.readAllLines(path);

        Collections.sort(rows);

        Files.write(Paths.get("D:\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\06.SortLinesOutput.txt") , rows);
    }
}
