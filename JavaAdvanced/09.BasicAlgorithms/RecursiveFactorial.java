import java.util.Scanner;

public class RecursiveFactorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());

        System.out.println(factoryel(number));
    }

    private static int factoryel(int number) {
        if (number == 1){
            return 1;
        }
        return number * (factoryel(number - 1));
    }
}
