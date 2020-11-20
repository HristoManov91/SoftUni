import java.util.Scanner;

public class GreaterOfTwoValues {
    
    static int GetMax( int firstOne , int secondOne ){
        if ( firstOne > secondOne ){
            return firstOne;
        }
        return secondOne;
    }

    static char GetMax ( char first , char second ){
        if ( first > second) {
            return first;
        }
        return second;
    }

    static String GetMax ( String first , String second ){
        if ( first.compareTo(second) >= 0 ){ // методът compareTo сравнява 2 String по лексикографията
            // като връща резултат положителен ако 1вият е по-голям,отрицателен ако е по малак и връща 0 ако са равни
            return first;
        }
        return second;
    }
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String typeOfVariable = scan.nextLine();
        switch (typeOfVariable){
            case "int":
                int num1 = Integer.parseInt(scan.nextLine());
                int num2 = Integer.parseInt(scan.nextLine());
                System.out.println(GetMax(num1 , num2));
                break;
            case "char":
                char firstChar = scan.nextLine().charAt(0);
                char secondChar = scan.nextLine().charAt(0);
                System.out.println(GetMax(firstChar , secondChar));
                break;
            case "string":
                String firstString = scan.nextLine();
                String secondString = scan.nextLine();
                System.out.println(GetMax( firstString , secondString ));
                break;
        }
    }
}
