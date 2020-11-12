import java.util.Scanner;

public class Login {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();
        StringBuilder password = new StringBuilder();
        password.append(username);
        password.reverse();


        boolean correctPassword = false;
        int count = 0;
        while (!correctPassword){
            String inputPassword = scanner.nextLine();
            count++;
            if (inputPassword.equals(password.toString()) && count <= 4){
                correctPassword = true;
                break;
            } else if ( count < 4){
                System.out.println("Incorrect password. Try again.");
            }
            if ( count == 4 && !correctPassword){
                System.out.printf("User %s blocked!", username);
                break;
            }
        }
        if (correctPassword){
            System.out.printf("User %s logged in.", username);
        }
    }
}
