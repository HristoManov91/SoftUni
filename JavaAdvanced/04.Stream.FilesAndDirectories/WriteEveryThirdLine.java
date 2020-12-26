import java.io.*;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WriteEveryThirdLine {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Manovi\\Desktop\\" +
                "04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt"));

        //BufferedReader reader1 = new BufferedReader(new InputStreamReader(System.in));така чете от конзолата

        BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\Manovi\\Desktop\\" +
                "04. Java-Advanced-Files-and-Streams-Lab-Resources\\05.WriteEveryThirdLineOutput.txt"));

        Stream<String> lines = reader.lines();

        List<String> stringLines = lines.collect(Collectors.toList());


        for (int i = 0; i < stringLines.size(); i++) {
            if ((i + 1) % 3 == 0){
                writer.write(stringLines.get(i));//отпечатай във файла
                writer.newLine();//отпечатай на нов ред
            }
        }
        writer.close();
    }
}
