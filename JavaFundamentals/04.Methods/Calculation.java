import java.util.Scanner;

public class Calculation {

    public static int Add ( int number1 , int number2 ){
        return (number1 + number2);
    }

    public static int Multiple ( int number1 , int number2 ){
        return (number1 * number2);
    }

    public static int Subtract ( int number1 , int number2 ){
        return (number1 - number2);
    }

    public static int Divide ( int number1 , int number2 ){
        return (number1 / number2);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String manipulation = scan.nextLine();
        int num1 = Integer.parseInt(scan.nextLine());
        int num2 = Integer.parseInt(scan.nextLine());

        //("add", "multiply", "subtract", "divide")
        if ( manipulation.equals("add")){
            System.out.println(Add(num1 , num2));
        }
        else if ( manipulation.equals("multiply")){
            System.out.println(Multiple(num1 , num2));
        }
        else if ( manipulation.equals("subtract")){
            System.out.println(Subtract(num1 , num2));
        }
        else if ( manipulation.equals("divide")){
            System.out.println(Divide(num1 , num2));
        }

    }
}
