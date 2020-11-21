import java.util.Scanner;

public class SignOfIntegerNumbers {

    static void signInteger (int number){
        if (number > 0){
            System.out.printf("The number %d is positive.",number);
        } else if ( number < 0){
            System.out.printf("The number %d is negative.",number);
        } else {
            System.out.println("The number 0 is zero.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        signInteger(number);
    }
}
