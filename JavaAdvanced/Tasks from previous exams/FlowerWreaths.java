import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class FlowerWreaths {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> lilies = new ArrayDeque<>();
        int[] inputLilies = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();

        for (int inputLily : inputLilies) {
            lilies.push(inputLily);
        }

        ArrayDeque<Integer> roses = new ArrayDeque<>();
        int[] inputRoses = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();

        for (int inputRose : inputRoses) {
            roses.offer(inputRose);
        }

        int countWreaths = 0;
        int storeSum = 0;
        while (lilies.size() > 0 && roses.size() > 0){
            int quantityLilies = lilies.pop();
            int quantityRoses = roses.poll();

            while (quantityLilies + quantityRoses > 15){
                quantityLilies -= 2;
            }

            if (quantityLilies + quantityRoses == 15){
                countWreaths++;
            } else if (quantityLilies + quantityRoses < 15){
                storeSum += quantityLilies + quantityRoses;
            }
        }
        countWreaths += storeSum / 15;
        if (countWreaths >= 5){
            System.out.printf("You made it, you are going to the competition with %d wreaths!", countWreaths);
        } else {
            System.out.printf("You didn't make it, you need %d wreaths more!", 5 - countWreaths);
        }
    }
}
