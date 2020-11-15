import java.util.Scanner;

public class Elevator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int people = Integer.parseInt(scanner.nextLine());
        int capacityElevator = Integer.parseInt(scanner.nextLine());

        int countCourses = people / capacityElevator;
        if (people % capacityElevator > 0){
            countCourses++;
        }
        System.out.println(countCourses);
    }
}
