import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SecondProblem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countOfMessage = Integer.parseInt(scanner.nextLine());
        String regex = "^([$%])(?<tag>[A-Z][a-z]{3,})\\1: \\[((?<first>[0-9]+)\\]\\|\\[(?<second>[0-9]+)\\]\\|\\[(?<third>[0-9]+)\\]\\|)$";
        Pattern pattern = Pattern.compile(regex);

        for (int i = 0; i < countOfMessage; i++) {
            String text = scanner.nextLine();
            Matcher matcher = pattern.matcher(text);
            if (matcher.find()){
                StringBuilder sb = new StringBuilder();
                int firstPosition = Integer.parseInt(matcher.group("first"));
                int secondPosition =Integer.parseInt(matcher.group("second"));
                int thirdPosition = Integer.parseInt(matcher.group("third"));

                sb.append(getSymbolFromASCII(firstPosition));
                sb.append(getSymbolFromASCII(secondPosition));
                sb.append(getSymbolFromASCII(thirdPosition));
                System.out.printf("%s: %s%n", matcher.group("tag") , sb.toString());
            } else {
                System.out.println("Valid message not found!");
            }

        }
    }

    private static char getSymbolFromASCII(int digit) {
        return (char) (digit);
    }

}
