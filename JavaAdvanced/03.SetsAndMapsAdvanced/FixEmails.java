import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String , String> emailData = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("stop")){
            String email = scanner.nextLine();
            String[] emailArr = email.split("\\.");
            if (emailArr[emailArr.length - 1].equals("bg")){
                emailData.put(input , email);
            }
            input = scanner.nextLine();
        }
        for (Map.Entry<String, String> name : emailData.entrySet()) {
            System.out.println(name.getKey() + " -> " + name.getValue());
        }
    }
}
