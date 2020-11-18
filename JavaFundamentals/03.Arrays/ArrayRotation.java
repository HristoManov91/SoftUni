import java.util.Scanner;

public class ArrayRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] array = scanner.nextLine().split(" ");
        int rotation = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < rotation; i++) {
                String token = array[0];
                for (int k = 0; k < array.length - 1; k++) {
                    array[k] = array[k + 1];
                }
                array[array.length - 1] = token;
            }
        for (String element : array) {
            System.out.print(element + " ");
        }
    }
}
