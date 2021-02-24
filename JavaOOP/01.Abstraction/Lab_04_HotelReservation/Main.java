package Lab_04_HotelReservation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        double pricePerDay = Double.parseDouble(input[0]);
        int countDays = Integer.parseInt(input[1]);
        Season season = Season.valueOf(input[2].toUpperCase());
        Discount discount = Discount.valueOf(input[3].toUpperCase());

        PriceCalculator priceCalculator = new PriceCalculator(pricePerDay , countDays , season , discount);
        System.out.printf("%.2f" , priceCalculator.calculatePriceForHoliday());
    }
}
