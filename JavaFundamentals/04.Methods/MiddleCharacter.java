import java.util.Scanner;

public class MiddleCharacter {

    static void printMiddleCharacter (String string){
        int middleIndex = string.length() / 2;
        if (string.length() % 2 == 0){
            System.out.println(string.substring(middleIndex - 1, middleIndex + 1));
        } else {
            System.out.println(string.charAt(middleIndex));
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        printMiddleCharacter(input);
    }
}
