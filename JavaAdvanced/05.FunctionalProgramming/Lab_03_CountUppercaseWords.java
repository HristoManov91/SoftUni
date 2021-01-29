import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class Lab_03_CountUppercaseWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] words = scanner.nextLine().split(" ");

        Predicate<String> wordStartWithUppercase = s -> Character.isUpperCase(s.charAt(0));

        int count = 0;
        for (String word : words) {
            if (wordStartWithUppercase.test(word)){
                count++;
            }
        }
        System.out.println(count);

        Arrays.stream(words).filter(wordStartWithUppercase).forEach(System.out::println);
    }
}
