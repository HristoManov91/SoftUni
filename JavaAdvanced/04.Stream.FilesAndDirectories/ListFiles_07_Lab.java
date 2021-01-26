import java.io.File;
import java.util.Arrays;
import java.util.List;

public class ListFiles_07_Lab {
    public static void main(String[] args) {
        File file = new File("D:\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams");

        List<File> files = Arrays.asList(file.listFiles().clone());

        for (File inputFile : files) {
            if (!inputFile.isDirectory()) {
                System.out.printf("%s: [%d]%n", inputFile.getName(), inputFile.length());
            }
        }
    }
}
