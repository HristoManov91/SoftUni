import java.util.Scanner;

public class SpecialNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String count = scanner.nextLine();


        for (int i = 1; i <= Integer.parseInt(count) ; i++) {
            int currentNumber = i;
            int sum = 0;
            while (currentNumber > 0){
             sum += currentNumber % 10;
             currentNumber /= 10;
            }
            if ((sum == 5) || (sum == 7) || (sum == 11)){
                System.out.printf("%s -> True%n", i);
            } else {
                System.out.printf("%s -> False%n", i);
            }
        }
    }
}
