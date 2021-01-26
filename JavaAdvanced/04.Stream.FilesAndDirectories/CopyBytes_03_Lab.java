import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class CopyBytes_03_Lab {
    public static void main(String[] args) throws IOException {
        FileInputStream reader =
                new FileInputStream("D:\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt");

        FileOutputStream writer =
                new FileOutputStream("D:\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\03.CopyBytesOutput.txt");

        int oneByte = 0;
        while ((oneByte = reader.read()) >= 0) {
            if (oneByte == 10 || oneByte == 32){
                writer.write(oneByte);
            } else {
                writer.write(String.valueOf(oneByte).getBytes(StandardCharsets.UTF_8));
            }
        }
        writer.close();
    }
}
