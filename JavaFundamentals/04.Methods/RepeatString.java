import java.util.Scanner;

public class RepeatString {

    public static String Repeat ( String word , int times ){
        String output = "";
        for (int i = 1; i <= times ; i++) {
            output = output + word;
        }
        return output;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        int times = Integer.parseInt(scan.nextLine());

        System.out.print(Repeat( input , times));
    }
}
