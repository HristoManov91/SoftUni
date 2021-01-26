import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

public class WriteEveryThirdLine_05_Lab {
    public static void main(String[] args) throws IOException {
        String inputPath = "D:\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        BufferedReader reader = new BufferedReader(new FileReader(inputPath));

        String outputPath = "D:\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\05.WriteEveryThirdLineOutput.txt";
        PrintWriter writer = new PrintWriter(new FileWriter(outputPath));

        List<String> rows = reader.lines().collect(Collectors.toUnmodifiableList());

        for (int i = 2; i < rows.size(); i+=3) {
            writer.println(rows.get(i));
        }
        writer.close();
    }
}
