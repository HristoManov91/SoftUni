import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CountCharacterType_04_Exercise {
    public static void main(String[] args) throws FileNotFoundException {
        String inputPath = "D:\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        BufferedReader reader = new BufferedReader(new FileReader(inputPath));

        PrintWriter writer = new PrintWriter("D:\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt");

        List<String> rows = reader.lines().collect(Collectors.toUnmodifiableList());
        List<Character> vowels = new ArrayList<>();
        Collections.addAll(vowels , 'a', 'e', 'i', 'o', 'u');
        List<Character> punctuations = new ArrayList<>();
        Collections.addAll(punctuations, '!',',','.','?');
        int countVowels = 0;
        int countPunctuations = 0;
        int countConsonants = 0;
        for (String row : rows) {
            char[] arr = row.toCharArray();
            for (char c : arr) {
                if (vowels.contains(c)){
                    countVowels++;
                } else if (punctuations.contains(c)){
                    countPunctuations++;
                } else if (c != ' ' && c != '\n') {
                    countConsonants++;
                }
            }
        }
        //Vowels: 41
        //Consonants: 72
        //Punctuation: 6
        System.out.printf("Vowels: %d%n", countVowels);
        System.out.printf("Consonants: %d%n", countConsonants);
        System.out.printf("Punctuation: %d", countPunctuations);
    }
}
