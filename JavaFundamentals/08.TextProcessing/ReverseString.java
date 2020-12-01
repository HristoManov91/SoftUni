import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();
        while (!word.equals("end")){
            String reverseWord = reverseWord(word);
            System.out.println(word + " = " + reverseWord);
            word = scanner.nextLine();
        }
    }
    private static String reverseWord (String word){
        char[] charArray = word.toCharArray();
        String result = "";
        for (int i = charArray.length - 1; i >= 0 ; i--) {
            result += charArray[i];
        }
        return result;
    }
}
