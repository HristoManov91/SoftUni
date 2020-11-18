import java.util.Scanner;

public class ZigZagArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());
        String[] array1 = new String[count];
        String[] array2 = new String[count];

        for (int i = 0; i < count; i++) {
            String[] input = scanner.nextLine().split(" ");
            if (i % 2 == 0){
                array1[i] = input[0];
                array2[i] = input[1];
            } else {
                array2[i] = input[0];
                array1[i] = input[1];
            }
        }
        for (String element : array1) {
            System.out.print(element + " ");
        }
        System.out.println();
        for (String element : array2) {
            System.out.print(element + " ");
        }
    }
}
