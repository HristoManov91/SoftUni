import java.io.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MergeTwoFile {
    public static void main(String[] args) throws IOException {
        BufferedReader fileReader = new BufferedReader(
                new FileReader("D:\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputOne.txt"));

        Stream<String> lines = fileReader.lines();
        List<String> linesList = lines.collect(Collectors.toList());

        fileReader = new BufferedReader(
                new FileReader("D:\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputTwo.txt"));

        lines = fileReader.lines();
        linesList.addAll(lines.collect(Collectors.toList()));

        BufferedWriter writer = new BufferedWriter(
                new FileWriter("D:\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt"));

        for (String element : linesList) {
            writer.write(element);
            writer.newLine();
        }
        writer.close();
    }
}
