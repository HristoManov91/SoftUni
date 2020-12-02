import java.util.Scanner;

public class CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        String firstWord = input[0];
        String secondWord = input[1];

        int totalSum = 0;
        if (firstWord.length() >= secondWord.length()){
            for (int i = 0; i < firstWord.length(); i++) {
                if (i < secondWord.length()){
                    int sum = firstWord.charAt(i) * secondWord.charAt(i);
                    totalSum += sum;
                } else {
                    totalSum += firstWord.charAt(i);
                }
            }
        } else {
            for (int i = 0; i < secondWord.length(); i++) {
                if (i < firstWord.length()){
                    int sum = firstWord.charAt(i) * secondWord.charAt(i);
                    totalSum += sum;
                } else {
                    totalSum += secondWord.charAt(i);
                }
            }
        }
        System.out.println(totalSum);
    }
}
