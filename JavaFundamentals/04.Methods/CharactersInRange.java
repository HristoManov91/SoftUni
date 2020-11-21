import java.util.Scanner;

public class CharactersInRange {

    static void printCharacterBetweenTwoCharacter (char firstChar , char secondChar){
        StringBuilder sb = new StringBuilder();
        for (int i = firstChar + 1; i < secondChar; i++) {
            char currentChar = (char) i;
            sb.append(currentChar).append(" ");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char characterOne = scanner.nextLine().charAt(0);
        char characterTwo = scanner.nextLine().charAt(0);
        if (characterOne < characterTwo) {
            printCharacterBetweenTwoCharacter(characterOne, characterTwo);
        } else {
            printCharacterBetweenTwoCharacter(characterTwo , characterOne);
        }
    }
}
