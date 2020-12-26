import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class ExtractIntegers {
    public static void main(String[] args) throws FileNotFoundException {
        String path = "C:\\Users\\Manovi\\Desktop\\04. Java-Advanced-Files-and-Streams-Lab-Resources" +
                "\\input.txt";//пътя до файла

        FileReader reader = new FileReader(path);

        Scanner scanner = new Scanner(new FileInputStream(path));

        PrintWriter writer = new PrintWriter("C:\\Users\\Manovi\\Desktop\\" +
                "04. Java-Advanced-Files-and-Streams-Lab-Resources\\04.ExtractIntegersOutput.txt");

        while (scanner.hasNext()){//питаме има ли такава стойност
            if (scanner.hasNextInt()){//питаме следващата стойност Int ли е? ако е печатаме
                int number = scanner.nextInt();
                writer.println(number);
            }
            scanner.next();
        }
        //writer.flush(); flash само празни буфера
        writer.close(); //close затваря поток и вече не може да бъде достъпен и запазва всички промени и празни буфера
    }
}
