import java.util.Scanner;

public class VowelsCount {

    static int countVowelsInString (String input){
        int vowelsCount = 0;
        for (int i = 0; i < input.length(); i++) {
            char character = input.charAt(i);
            switch (character){
                case 'a':
                case 'i':
                case 'u':
                case 'e':
                case 'y':
                case 'o':
                    vowelsCount++;
            }
        }
        return vowelsCount;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        input = input.toLowerCase();

        System.out.println(countVowelsInString(input));
    }
}
