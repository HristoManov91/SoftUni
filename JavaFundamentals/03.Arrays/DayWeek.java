import java.util.Scanner;

public class DayWeek {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] dayWeek = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        int day = Integer.parseInt(scanner.nextLine());
        if (day > 0 && day <= 7) {
            System.out.println(dayWeek[day - 1]);
        } else {
            System.out.println("Invalid day!");
        }
    }
}
