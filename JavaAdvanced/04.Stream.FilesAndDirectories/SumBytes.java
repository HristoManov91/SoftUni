import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SumBytes {
    public static void main(String[] args) throws FileNotFoundException {
        BufferedReader reader = new BufferedReader(//четем редове от входният файл
                new FileReader("D:\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt"));

        Stream<String> lines = reader.lines();

        List<String> stringLines = lines.collect(Collectors.toList());

        int countSymbolsASCII = 0;
        for (String line : stringLines) {
            char[] symbols = line.toCharArray();
            for (int i = 0; i < symbols.length; i++) {
                countSymbolsASCII += symbols[i];
            }
        }
        System.out.println(countSymbolsASCII);
    }
}
