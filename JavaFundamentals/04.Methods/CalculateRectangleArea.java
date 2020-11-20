import java.util.Scanner;

public class CalculateRectangleArea {

    public static int FindArea ( int sideA , int sideB ){
        return ( sideA * sideB );
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int a = Integer.parseInt(scan.nextLine());
        int b = Integer.parseInt(scan.nextLine());

        System.out.println(FindArea( a , b));
    }
}
