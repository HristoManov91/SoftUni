import java.io.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CountCharacterType {
    public static void main(String[] args) throws FileNotFoundException {
        BufferedReader reader = new BufferedReader(
                new FileReader("D:\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt"));

        PrintWriter writer = new PrintWriter("D:\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt");

        Stream<String> lineStream = reader.lines();

        List<String> listLines = lineStream.collect(Collectors.toList());

        int countVowels = 0;
        int countPunctuation = 0;
        int countConsonants = 0;


        for (String line : listLines) {
            char[] symbols = line.toCharArray();
            for (int i = 0; i < symbols.length; i++) {
                char symbol = symbols[i];
                switch (symbol){
                    case 'a':
                    case 'o':
                    case 'e':
                    case 'u':
                    case 'i':
                        countVowels++;
                        break;
                    case '!':
                    case ',':
                    case '.':
                    case '?':
                        countPunctuation++;
                        break;
                    case ' ':
                    case '\n':
                        break;
                    default:
                        countConsonants++;
                        break;
                }
            }
        }
        writer.write("Vowels: " + countVowels);
        writer.println();
        writer.println("Consonants: " + countConsonants);
        writer.println("Punctuation: " + countPunctuation);
        writer.close();
    }
}
