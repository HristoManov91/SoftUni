import java.text.DecimalFormat;
import java.util.Scanner;

public class MathPower {

    public static Double PowerOfNumber ( double number , int power ){
        double result = 1;
        for (int i = 1; i <= power ; i++) {
            result = result * number;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double num1 = Double.parseDouble(scan.nextLine());
        int power = Integer.parseInt(scan.nextLine());

        double result = PowerOfNumber(num1 , power );
        DecimalFormat df = new DecimalFormat("0.####");
        System.out.println(df.format(result));
    }
}
