import java.util.Scanner;

public class SumOfOddNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());

        int total = 0;
        int numbers = 0;

        for (int i = 1; i <= 100 ; i++) {
            if ( i % 2 == 1){
                numbers++;
                total += i;
                System.out.println(i);
            }
            if ( count == numbers){
                break;
            }
        }
        System.out.printf("Sum: %d", total);;
    }
}
