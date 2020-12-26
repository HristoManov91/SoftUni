import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CopyBytes {
    public static void main(String[] args) throws IOException {
        //директорията от която четем входните данни
        String path = "C:\\Users\\Manovi\\Desktop\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        //инпут поток от директорията
        FileInputStream inputStream = new FileInputStream(path);

        Scanner scanner = new Scanner(inputStream);//четем от директорията

        //файла с изходният резултат
        FileOutputStream outputStream = new FileOutputStream("C:\\Users\\Manovi\\Desktop\\" +
                "04. Java-Advanced-Files-and-Streams-Lab-Resources\\03.CopyBytesOutput.txt");

        int nextByte = inputStream.read();//четем всеки следващ байт

        while (nextByte != -1){

            if (nextByte == ' ' || nextByte == '\n'){//ако байта е спейс или нов ред
                outputStream.write(nextByte);//си го парсваме както си е
            } else {
                //ако не го парсваме като неговият ASCII код
                outputStream.write(String.valueOf(nextByte).getBytes(StandardCharsets.UTF_8));
            }
            nextByte = inputStream.read();//четем следващият байт
        }

        outputStream.close();//затваряме изходният поток
    }
}
