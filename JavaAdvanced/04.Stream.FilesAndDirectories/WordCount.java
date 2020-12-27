import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordCount {
    public static void main(String[] args) throws FileNotFoundException {
        String path = ("D:\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\words.txt");

        FileInputStream inputStream = new FileInputStream(path);

        Scanner scanner = new Scanner(inputStream);
        List<String> wordsList = new ArrayList<>();
        while (scanner.hasNext()){
            wordsList.add(scanner.next());
        }

        String pathText = "D:\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\text.txt";
        inputStream = new FileInputStream(pathText);
        scanner = new Scanner(inputStream);
        List<String> wordsInText = new ArrayList<>();
        while (scanner.hasNext()){
            wordsInText.add(scanner.next());
        }

        Map<String, Integer> searchingWords = new LinkedHashMap<>();

        for (String word : wordsList) {
            int count = 0;
            for (String wordInText : wordsInText) {
                if (word.equals(wordInText)){
                    count++;
                }
            }
            searchingWords.put(word , count);
        }
        PrintWriter writer = new PrintWriter("results.txt");
        for (Map.Entry<String, Integer> countWord : searchingWords.entrySet()) {
            writer.println(countWord.getKey() + " - " + countWord.getValue());
        }
        writer.close();
    }
}
