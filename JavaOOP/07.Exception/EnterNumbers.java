import java.util.Scanner;

public class EnterNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            int first = Integer.parseInt(scanner.nextLine());
            int second = Integer.parseInt(scanner.nextLine());

            if (validNumbers(first , second)){
                for (int i = first; i <= second; i++) {
                    System.out.println(i);
                }
            };
        } catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }
    }

    private static boolean validNumbers(int first, int second) {
        if (first < 1 || first > second || second > 100){
            throw new IllegalArgumentException("Invalid number in range 1 < start < end < 100. ");
        }
        return true;
    }
}
