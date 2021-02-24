package Lab_02_PointInRectangle;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Point leftPoint = new Point(numbers[0] , numbers[1]);
        Point rightPoint = new Point(numbers[2] , numbers[3]);

        Rectangle rectangle = new Rectangle(leftPoint , rightPoint);

        int count = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < count; i++) {
            int[] pointCoordinates = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            Point pointToCheck = new Point(pointCoordinates[0] , pointCoordinates[1]);
            System.out.println(rectangle.containsPoint(pointToCheck));
        }
    }
}
