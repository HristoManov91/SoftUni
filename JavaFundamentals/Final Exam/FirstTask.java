import java.util.Locale;
import java.util.Scanner;

public class FirstTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder string = new StringBuilder(scanner.nextLine());

        String input = scanner.nextLine();
        while (!input.equals("End")){
            String[] commands = input.split("\\s+");
            switch (commands[0]){
                case "Translate":
                    String charToReplaced = commands[1];
                    String replacement = commands[2];
                    if (string.indexOf(charToReplaced) > -1) {
                        string = new StringBuilder(string.toString().replace(charToReplaced, replacement));
                        System.out.println(string);
                    }
                    break;
                case "Includes":
                    String stringToIncludes = commands[1];
                    if (string.indexOf(stringToIncludes) > -1){
                        System.out.println("True");
                    } else {
                        System.out.println("False");
                    }
                    break;
                case "Start":
                    String stringToStart = commands[1];
                    if (string.indexOf(stringToStart) == 0){
                        System.out.println("True");
                    } else {
                        System.out.println("False");
                    }
                    break;
                case "Lowercase":
                    string = new StringBuilder(string.toString().toLowerCase(Locale.ROOT));
                    System.out.println(string);
                    break;
                case "FindIndex":
                    String findLastIndex = commands[1];
                    System.out.println(string.lastIndexOf(findLastIndex));
                    break;
                case "Remove":
                    int indexFromStartRemove = Integer.parseInt(commands[1]);
                    int countCharToRemove = Integer.parseInt(commands[2]);
                    string.delete(indexFromStartRemove , indexFromStartRemove + countCharToRemove);
                    System.out.println(string);
                    break;
            }

            input = scanner.nextLine();
        }
    }
}
