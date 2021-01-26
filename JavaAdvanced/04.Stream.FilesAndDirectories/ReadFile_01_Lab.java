import java.io.FileInputStream;
import java.io.IOException;

public class ReadFile_01_Lab {
    public static void main(String[] args) throws IOException {
        String path = "D:\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        FileInputStream inputStream = new FileInputStream(path);

        int oneByte = inputStream.read();

        while (oneByte > -1){
            System.out.printf("%s ", Integer.toBinaryString(oneByte));
            oneByte = inputStream.read();
        }
    }
}
