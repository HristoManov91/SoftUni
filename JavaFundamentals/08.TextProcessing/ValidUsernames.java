import java.util.Scanner;

public class ValidUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(", ");

        for (String element : input) {
            boolean validName = true;
            if (element.length() < 3 || element.length() > 16){
                validName = false;
            }
            for (int i = 0; i < element.length(); i++) {
                char symbol = element.charAt(i);
                if (!Character.isLetterOrDigit(symbol) && symbol != '-' & symbol != '_'){
                    validName = false;
                    break;
                }
            }
            if (validName){
                System.out.println(element);
            }
        }
    }
}
