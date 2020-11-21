import java.util.Scanner;

public class Calculations {

    static void calculations (String operation , int number1 , int number2){
        int result = 0;
        switch (operation){
            case "subtract":
                result = number1 - number2;
                break;
            case "add":
                result = number1 + number2;
                break;
            case "multiply":
                result = number1 * number2;
                break;
            case "divide":
                result = number1 / number2;
                break;
        }
        System.out.println(result);
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String manipulation = scanner.nextLine();
        int firstNumber = Integer.parseInt(scanner.nextLine());
        int secondNumber = Integer.parseInt(scanner.nextLine());

        calculations(manipulation , firstNumber , secondNumber);
    }
}
