import java.util.Scanner;

public class SpiceMustFlow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int startingYield = Integer.parseInt(scanner.nextLine());
        int workDays = 0;
        int extractedAmount = 0;

        while (startingYield >= 100){
            extractedAmount += startingYield;
            workDays++;
            extractedAmount -= 26;
            startingYield -= 10;
        }
        if (extractedAmount > 26) {
            extractedAmount -= 26;
        }
        System.out.println(workDays);
        System.out.println(extractedAmount);
    }
}
