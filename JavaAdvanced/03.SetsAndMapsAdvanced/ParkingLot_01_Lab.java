import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class ParkingLot_01_Lab {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Set<String> carNumbers = new LinkedHashSet<>();
        while (!input.equals("END")){
            String[] tokens = input.split(", ");
            if (tokens[0].equals("IN")){
                carNumbers.add(tokens[1]);
            } else {
                carNumbers.remove(tokens[1]);
            }
            input = scanner.nextLine();
        }

        if (carNumbers.isEmpty()){
            System.out.println("Parking Lot is Empty");
        } else {
            for (String carNumber : carNumbers) {
                System.out.println(carNumber);
            }
        }
    }
}
