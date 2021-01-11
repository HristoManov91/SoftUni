import java.util.Scanner;

public class RhombusOfStars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        printTop(n);

        printBottom(n - 1);

    }
    private static void printTop(int rowsCount){
        for (int i = 1; i <= rowsCount; i++) {
            printString(rowsCount - i , " ");
            printString(i , "* ");
            System.out.println();
        }
    }
    private static void printBottom (int count){
        for (int i = 0; i < count; i++) {
            printString(i + 1 , " ");
            printString(count - i , "* ");
            System.out.println();
        }
    }

    private static void printString (int count , String str){
        for (int i = 0; i < count; i++) {
            System.out.print(str);
        }
    }
}
