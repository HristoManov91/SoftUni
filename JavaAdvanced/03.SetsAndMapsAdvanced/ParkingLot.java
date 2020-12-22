import java.util.*;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> carNumbers = new LinkedHashSet<>();

        String input = scanner.nextLine();
        while (!input.equals("END")){
            String[] token = input.split(", ");
            String command = token[0];
            String carNumber = token[1];

            switch (command){
                case "IN":
                    carNumbers.add(carNumber);
                    break;
                case "OUT":
                    carNumbers.remove(carNumber);
                    break;
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
