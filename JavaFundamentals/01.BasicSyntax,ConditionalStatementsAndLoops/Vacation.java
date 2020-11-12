import java.util.Scanner;

public class Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfPeople = Integer.parseInt(scanner.nextLine());
        String typeOfGroup = scanner.nextLine();
        String daysOfWeek = scanner.nextLine();

        double totalPrice = 0.0;

        switch (typeOfGroup) {
            case "Students":
                if (daysOfWeek.equals("Friday")) {
                    totalPrice = numberOfPeople * 8.45;
                } else if ( daysOfWeek.equals("Saturday")){
                    totalPrice = numberOfPeople * 9.80;
                } else if ( daysOfWeek.equals("Sunday")){
                    totalPrice = numberOfPeople * 10.46;
                }
                if ( numberOfPeople >= 30 ){
                    totalPrice = totalPrice * 0.85;
                }
            break;
            case "Business":
                if (daysOfWeek.equals("Friday")) {
                    totalPrice = numberOfPeople * 10.90;
                    if ( numberOfPeople >= 100 ){
                        totalPrice = totalPrice - ( 10 * 10.90);
                    }
                } else if ( daysOfWeek.equals("Saturday")){
                    totalPrice = numberOfPeople * 15.60;
                    if ( numberOfPeople >= 100 ){
                        totalPrice = totalPrice - ( 10 * 15.60);
                    }
                } else if ( daysOfWeek.equals("Sunday")){
                    totalPrice = numberOfPeople * 16;
                    if ( numberOfPeople >= 100 ){
                        totalPrice = totalPrice - ( 10 * 16);
                    }
                }
                break;
            case "Regular":
                if (daysOfWeek.equals("Friday")) {
                    totalPrice = numberOfPeople * 15;
                } else if ( daysOfWeek.equals("Saturday")){
                    totalPrice = numberOfPeople * 20;
                } else if ( daysOfWeek.equals("Sunday")){
                    totalPrice = numberOfPeople * 22.50;
                }
                if ( numberOfPeople >= 10 && numberOfPeople <= 20){
                    totalPrice = totalPrice * 0.95;
                }
                break;
        }
        System.out.printf("Total price: %.2f", totalPrice);
    }
}
