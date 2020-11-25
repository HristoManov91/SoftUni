import java.util.Random;
import java.util.Scanner;

public class RandomiseWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] words = input.split(" ");

        Random rnd = new Random();

        for (int i = 0; i < words.length - 1; i++) {
            String temp = words[i];
            int x = rnd.nextInt(words.length - 1);
            words[i] = words[x];
            words[x] = temp;
        }
        System.out.println(String.join(System.lineSeparator(), words));
    }
}
