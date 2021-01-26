import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WriteFile_02_Lab {
    public static void main(String[] args) throws IOException {
        FileInputStream reader =
                new FileInputStream("D:\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt");

        FileOutputStream writer =
                new FileOutputStream("D:\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\02.WriteToFileOutput.txt");

        List<Character> symbols = new ArrayList<>();
        Collections.addAll(symbols , ',', '.', '!', '?');

        int oneByte = reader.read();
        while (oneByte > -1){
            if (!symbols.contains((char) oneByte)){
                writer.write((char) oneByte);
            }
            oneByte = reader.read();
        }
    }
}
