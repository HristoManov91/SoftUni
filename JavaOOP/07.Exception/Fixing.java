import java.util.Scanner;

public class Fixing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] weekdays = new String[5];

        weekdays[0] = "Monday";
        weekdays[1] = "Tuesday";
        weekdays[2] = "Wednesday";
        weekdays[3] = "Thursday";
        weekdays[4] = "Friday";

        try {
            System.out.println(weekdays[Integer.parseInt(scanner.nextLine()) - 1]);
        } catch (IndexOutOfBoundsException exception){
            System.out.println(exception.getMessage());
        }
    }
}
