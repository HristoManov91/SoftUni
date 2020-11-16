import java.util.Scanner;

public class DayOfWeek {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] dayOfWeek = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        int day = Integer.parseInt(scan.nextLine());

        if ( day > 0 && day <= dayOfWeek.length ){
            System.out.println(dayOfWeek[day - 1]);
        } else {
            System.out.println("Invalid day!");
        }
    }
}
