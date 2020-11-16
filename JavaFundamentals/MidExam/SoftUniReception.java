import java.util.Scanner;

public class SoftUniReception {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int firstEmployee = Integer.parseInt(scanner.nextLine());
        int secondEmployee = Integer.parseInt(scanner.nextLine());
        int thirdEmployee = Integer.parseInt(scanner.nextLine());
        int studentsCount = Integer.parseInt(scanner.nextLine());

        int studentsPerHour = firstEmployee + secondEmployee + thirdEmployee;
        int hoursPerWork = 0;
        while (studentsCount > 0){
            hoursPerWork++;
            if (hoursPerWork % 4 == 0){
                continue;
            }
            studentsCount -= studentsPerHour;
        }
        System.out.printf("Time needed: %dh.", hoursPerWork);
    }
}
