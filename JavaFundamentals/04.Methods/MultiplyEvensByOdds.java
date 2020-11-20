import java.util.Scanner;

public class MultiplyEvensByOdds {

    static int getMultipleOfEvensAndOdds (String number){
        int result = getSumEvensNumbers ( number ) * getSumOddsNumbers ( number );
        return result;
    }

    static int getSumEvensNumbers ( String num ){
        int sum = 0;
        for (int i = 0; i < num.length(); i++) {
            if ( num.charAt(i) >= 49 && num.charAt(i) <= 57 ){
                int digit = Integer.parseInt(String.valueOf(num.charAt(i)));
                if ( digit % 2 == 0 ){
                    sum += digit;
                }
            }
        }
        return sum;
    }

    static int getSumOddsNumbers ( String num ){
        int sum = 0;
        for (int i = 0; i < num.length(); i++) {
            if ( num.charAt(i) >= 49 && num.charAt(i) <= 57 ){
                int digit = Integer.parseInt(String.valueOf(num.charAt(i)));
                if ( digit % 2 == 1 ){
                    sum += digit;
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String number = scan.nextLine();
        System.out.println(getMultipleOfEvensAndOdds(number));
    }
}
