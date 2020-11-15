import java.math.BigDecimal;
import java.util.Map;
import java.util.Scanner;

public class BeerKegs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfKegs = Integer.parseInt(scanner.nextLine());
        String biggestKeg = "";
        BigDecimal biggestKegCapacity = new BigDecimal(0);

        for (int i = 0; i < numberOfKegs; i++) {
            String type = scanner.nextLine();
            double radius = Double.parseDouble(scanner.nextLine());
            int height = Integer.parseInt(scanner.nextLine());
            BigDecimal capacity = new BigDecimal(Math.PI * (radius * radius) * height);
            if ( capacity.compareTo(biggestKegCapacity) > 0){
                biggestKeg = type;
                biggestKegCapacity = capacity;
            }
        }
        System.out.println(biggestKeg);
    }
}
