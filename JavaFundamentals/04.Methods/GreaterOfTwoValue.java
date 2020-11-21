import java.util.Scanner;

public class GreaterOfTwoValue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String type = scanner.nextLine();
        switch (type){
            case "int":
                int firstNumber = Integer.parseInt(scanner.nextLine());
                int secondNumber = Integer.parseInt(scanner.nextLine());
                System.out.println(getMax(firstNumber , secondNumber));
                break;
            case "char":
                char a = scanner.nextLine().charAt(0);
                char b = scanner.nextLine().charAt(0);
                System.out.println(getMax(a , b));
                break;
            case "string":
                String first = scanner.nextLine();
                String second = scanner.nextLine();
                System.out.println(getMax(first , second));
                break;
        }
    }
    static int getMax (int first , int second){
        return Math.max(first, second);
    }
    static char getMax (char a , char b){
        if (a > b){
            return a;
        }
        return b;
    }
    static String getMax (String first , String second){
        if (first.compareTo(second) >= 0){
            return first;
        }
        return second;
    }
}
