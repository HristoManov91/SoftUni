import java.io.*;
import java.util.Scanner;

public class ExtractIntegers_04_Lab {
    public static void main(String[] args) throws IOException {
        FileInputStream reader =
                new FileInputStream("D:\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt");

        PrintWriter writer =
                new PrintWriter("D:\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\04.ExtractIntegersOutput.txt");

        Scanner scanner = new Scanner(reader);
        while (scanner.hasNext()){
            if (scanner.hasNextInt()){
                writer.println(scanner.nextInt());
            }
            scanner.next();
        }
        writer.close();
    }
}
