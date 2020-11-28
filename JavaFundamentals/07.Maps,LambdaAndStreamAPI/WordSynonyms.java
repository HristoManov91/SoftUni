import java.util.*;

public class WordSynonyms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countSynonyms = Integer.parseInt(scanner.nextLine());

        Map<String, List<String>> wordSynonyms = new LinkedHashMap<>();
        for (int i = 0; i < countSynonyms; i++) {
            String word = scanner.nextLine();
            String synonym = scanner.nextLine();
                wordSynonyms.putIfAbsent(word , new ArrayList<>());
                wordSynonyms.get(word).add(synonym);
        }
        for (Map.Entry<String, List<String>> word: wordSynonyms.entrySet()){
            System.out.print(word.getKey() + " - ");
            System.out.println(word.getValue().toString().replaceAll("[\\[\\]]", ""));
        }
    }
}