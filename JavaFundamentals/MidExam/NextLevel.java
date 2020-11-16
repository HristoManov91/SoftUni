import java.util.Scanner;

public class NextLevel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double neededExperience = Double.parseDouble(scanner.nextLine());
        int countOfBattles = Integer.parseInt(scanner.nextLine());

        double sumOfExp = 0;
        for (int i = 1; i <= countOfBattles; i++) {
            double experienceFromBattle = Double.parseDouble(scanner.nextLine());
            sumOfExp += experienceFromBattle;
            if (i % 3 == 0){
                sumOfExp += experienceFromBattle * 0.15;
            }
            if (i % 5 == 0){
                sumOfExp -= experienceFromBattle * 0.1;
            }
            if (i % 15 == 0){
                sumOfExp += experienceFromBattle * 0.05;
            }
            if (sumOfExp >= neededExperience){
                System.out.printf("Player successfully collected his needed experience for %d battles.", i);
                break;
            }
        }
        if (sumOfExp < neededExperience){
            System.out.printf("Player was not able to collect the needed experience, %.2f more needed.",
                    neededExperience - sumOfExp);
        }
    }
}
