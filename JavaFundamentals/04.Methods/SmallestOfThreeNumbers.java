import java.util.Scanner;

public class SmallestOfThreeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int smallestNumber = Integer.MAX_VALUE;

        for (int i = 0; i < 3; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            if (number < smallestNumber){
                smallestNumber = number;
            }
        }
        System.out.println(smallestNumber);
    }
}
