import java.text.DecimalFormat;
import java.util.Scanner;

public class MathOperations {

    static int getSum ( int num1 , int num2){
        return num1 + num2;
    }

    static int getSubtract (int num1 , int num2){
        return num1 - num2;
    }

    static int getMultiple ( int num1, int num2){
        return num1 * num2;
    }

    static double getDivide ( int num1 , int num2){
        return num1 * 1.0 / num2;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int firstNumber = Integer.parseInt(scan.nextLine());
        char sign = scan.nextLine().charAt(0);
        int secondNumber = Integer.parseInt(scan.nextLine());

        double result = 0;
        switch (sign){
            case '+':
                result = getSum(firstNumber , secondNumber);
                break;
            case '/':
                result = getDivide( firstNumber , secondNumber);
                break;
            case '-':
                result = getSubtract ( firstNumber , secondNumber);
                break;
            case '*':
                result = getMultiple ( firstNumber , secondNumber);
                break;
        }
        DecimalFormat df = new DecimalFormat("#.#");
        System.out.println(df.format(result));
    }
}
