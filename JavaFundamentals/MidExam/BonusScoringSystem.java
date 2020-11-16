import java.util.Scanner;

public class BonusScoringSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countStudents = Integer.parseInt(scanner.nextLine());
        int countLectures = Integer.parseInt(scanner.nextLine());
        int bonusPoints = Integer.parseInt(scanner.nextLine());

        double maxBonusPoints = 0;
        int maxAttendance = 0;
        for (int i = 0; i < countStudents; i++) {
            int studentsAttendance = Integer.parseInt(scanner.nextLine());
            if (studentsAttendance > maxAttendance){
                maxAttendance = studentsAttendance;
            }
            double points = studentsAttendance * 1.0 / countLectures * (5 + bonusPoints);
            if ( maxBonusPoints < points){
                maxBonusPoints = points;
            }
        }
        System.out.printf("Max Bonus: %.0f.%n", maxBonusPoints);
        System.out.printf("The student has attended %d lectures.", maxAttendance);
    }
}
