import java.util.Scanner;

public class PasswordReset {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder string = new StringBuilder(scanner.nextLine());

        String input = scanner.nextLine();
        while (!input.equals("Done")){
            String[] command = input.split("\\s+");
            switch (command[0]){
                case "TakeOdd":
                    StringBuilder onlyOddCharacters = new StringBuilder();
                    for (int i = 0; i < string.length(); i++) {
                        if ( i % 2 == 1) {
                            onlyOddCharacters.append(string.charAt(i));
                        }
                    }
                    string = onlyOddCharacters;
                    System.out.println(string);
                    break;
                case "Cut":
                    int startIndexToCut = Integer.parseInt(command[1]);
                    int length = Integer.parseInt(command[2]);
                    string.delete(startIndexToCut , startIndexToCut + length);
                    System.out.println(string);
                    break;
                case "Substitute":
                    String substring = command[1];
                    String substitute = command[2];
                    if (string.indexOf(substring) == -1){
                        System.out.println("Nothing to replace!");
                    } else {
                        while (string.toString().contains(substring)) {
                            string = new StringBuilder(string.toString().replaceAll(substring, substitute));
                        }
                        System.out.println(string);
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.printf("Your password is: %s", string);
    }
}
