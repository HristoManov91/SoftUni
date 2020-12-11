import java.util.Scanner;

public class TheImitationGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder message = new StringBuilder(scanner.nextLine());

        String command = scanner.nextLine();
        while (!command.equals("Decode")){
            String[] tokens = command.split("\\|");
            switch (tokens[0]){
                case "Move":
                    int numberOfLettersToMoveToBack = Integer.parseInt(tokens[1]);
                    StringBuilder newSb = new StringBuilder();
                    newSb.append(message.substring(numberOfLettersToMoveToBack));
                    newSb.append(message.substring( 0 ,numberOfLettersToMoveToBack));
                    message.setLength(0);
                    message.append(newSb);
                    break;
                case "Insert":
                    int indexToInsert = Integer.parseInt(tokens[1]);
                    String value = tokens[2];
                    message.insert(indexToInsert , value);
                    break;
                case "ChangeAll":
                    String substring = tokens[1];
                    String replacement = tokens[2];
                    message = new StringBuilder(message.toString().replace(substring , replacement));
                    break;
            }
            command = scanner.nextLine();
        }
        System.out.println("The decrypted message is: " + message);
    }
}
