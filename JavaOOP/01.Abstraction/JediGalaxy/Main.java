package JediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimestions = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int x = dimestions[0];
        int y = dimestions[1];

        Matrix matrix = new Matrix(0 , x , y);

        String command = scanner.nextLine();
        long sum = 0;
        while (!command.equals("Let the Force be with you")) {
            int[] ivoS = Arrays.stream(command.split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] evil = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int rowEvil = evil[0];
            int colEvil = evil[1];

            matrix.evilDestroyCoordinates(rowEvil , colEvil);

            int rowIvo = ivoS[0];
            int colIvo = ivoS[1];

            sum += matrix.collectCoordinates(rowIvo , colIvo);

            command = scanner.nextLine();
        }
        System.out.println(sum);
    }
}
