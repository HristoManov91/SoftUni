import java.util.Scanner;

public class AddAndSubtract {

    static int addTwoNumbers (int first , int second){
        return first + second;
    }

    static int thirdNumberSubtractSumFirstTwoNumbers ( int third , int second , int first){
        return addTwoNumbers(second , first) - third;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int firstNumber = Integer.parseInt(scanner.nextLine());
        int secondNumber = Integer.parseInt(scanner.nextLine());
        int thirdNumber = Integer.parseInt(scanner.nextLine());

        System.out.println(thirdNumberSubtractSumFirstTwoNumbers(thirdNumber , secondNumber , firstNumber));
    }
}
