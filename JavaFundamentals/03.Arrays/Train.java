import java.util.Scanner;

public class Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countWagons = Integer.parseInt(scanner.nextLine());

        int[] arrays = new int[countWagons];
        int sum = 0;

        for (int i = 0; i < countWagons; i++) {
            int num = Integer.parseInt(scanner.nextLine());
            sum += num;
            arrays[i] = num;
        }
        for (int num : arrays) {
            System.out.print(num + " ");
        }
        System.out.println();
        System.out.println(sum);
    }
}
