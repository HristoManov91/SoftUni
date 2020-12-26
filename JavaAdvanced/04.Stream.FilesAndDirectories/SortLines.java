import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class SortLines {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("C:\\Users\\Manovi\\Desktop\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt");

        List<String> strings = Files.readAllLines(path);

        Collections.sort(strings);

        Files.write(Paths.get("C:\\Users\\Manovi\\Desktop\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\06.SortLinesOutput.txt"), strings);
    }
}
