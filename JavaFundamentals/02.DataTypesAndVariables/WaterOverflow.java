import java.util.Scanner;

public class WaterOverflow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countPour = Integer.parseInt(scanner.nextLine());
        int waterInTank = 0;
        int maxWaterTank = 255;

        for (int i = 0; i < countPour; i++) {
            int waterForPour = Integer.parseInt(scanner.nextLine());
            if (waterInTank + waterForPour <= maxWaterTank){
                waterInTank += waterForPour;
            } else {
                System.out.println("Insufficient capacity!");
            }
        }
        System.out.println(waterInTank);
    }
}
