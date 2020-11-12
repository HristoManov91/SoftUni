import java.util.Scanner;

public class PadawanEquipment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double moneyWeHave = Double.parseDouble(scanner.nextLine());
        int students = Integer.parseInt(scanner.nextLine());
        double priceOfSingleLightSabers = Double.parseDouble(scanner.nextLine());
        double priceOfSingleRobe = Double.parseDouble(scanner.nextLine());
        double priceOfSingleBelt = Double.parseDouble(scanner.nextLine());

        double priceForRobes = priceOfSingleRobe * students;
        double priceForLightSabers = students * priceOfSingleLightSabers
                + ( Math.ceil(students * 0.1) * priceOfSingleLightSabers);
        double priceForBelts = (students - (students / 6)) * priceOfSingleBelt;

        double moneyNeeded = priceForRobes + priceForLightSabers + priceForBelts;

        if ( moneyWeHave >= moneyNeeded ){
            System.out.printf("The money is enough - it would cost %.2flv.", moneyNeeded);
        } else {
            System.out.printf("Ivan Cho will need %.2flv more.", moneyNeeded - moneyWeHave);
        }
    }
}
