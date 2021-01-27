import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;

public class MergeTwoFile_07_Exercise {
    public static void main(String[] args) throws FileNotFoundException {
        String pathFirstFile = "D:\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputOne.txt";
        BufferedReader reader = new BufferedReader(new FileReader(pathFirstFile));
        List<String> list = reader.lines().collect(Collectors.toList());

        String pathSecondFile = "D:\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputTwo.txt";
        reader = new BufferedReader(new FileReader(pathSecondFile));
        list.addAll(reader.lines().collect(Collectors.toUnmodifiableList()));

        PrintWriter writer =
                new PrintWriter("D:\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\mergeTwoFiles.txt");

        for (String s : list) {
            writer.write(s);
            writer.println();
        }
        writer.close();
    }
}
