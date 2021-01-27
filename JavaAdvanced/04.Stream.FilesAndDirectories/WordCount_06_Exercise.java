import java.io.*;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WordCount_06_Exercise {
    public static void main(String[] args) throws IOException {
        String inputPath = "D:\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\words.txt";
        BufferedReader reader = new BufferedReader(new FileReader(inputPath));

        String[] words = reader.readLine().split("\\s+").clone();

        inputPath = "D:\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\text.txt";
        reader = new BufferedReader(new FileReader(inputPath));

        String[] wordsInText = reader.readLine().split("\\s+").clone();

        PrintWriter writer =
                new PrintWriter("D:\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\results.txt");

        Map<String , Integer> wordsCount = new LinkedHashMap<>();
        for (String searchingWord : words) {
            for (String  wordInText : wordsInText) {
                if (searchingWord.equals(wordInText)){
                    wordsCount.putIfAbsent(searchingWord , 0);
                    wordsCount.put(searchingWord , wordsCount.get(searchingWord) + 1);
                }
            }
        }
        for (Map.Entry<String, Integer> stringIntegerEntry : wordsCount.entrySet()) {
            writer.println(String.format("%s - %s", stringIntegerEntry.getKey() , stringIntegerEntry.getValue()));
        }
        writer.close();
    }
}
