import java.util.Scanner;

public class TheatrePromotions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String typeOfDay = scanner.nextLine();
        int ageOfPerson = Integer.parseInt(scanner.nextLine());

        switch (typeOfDay) {
            case "Weekday":
                if (ageOfPerson >= 0 && ageOfPerson <= 18 || ageOfPerson > 64 && ageOfPerson <= 122) {
                    System.out.println("12$");
                } else if (ageOfPerson > 18 && ageOfPerson <= 64) {
                    System.out.println("18$");
                }  else {
                    System.out.println("Error!");
                }
                break;
            case "Weekend":
                if (ageOfPerson >= 0 && ageOfPerson <= 18 || ageOfPerson > 64 && ageOfPerson <= 122) {
                    System.out.println("15$");
                } else if (ageOfPerson > 18 && ageOfPerson <= 64) {
                    System.out.println("20$");
                } else {
                    System.out.println("Error!");
                }
                break;
            case "Holiday":
                if ( ageOfPerson >= 0 && ageOfPerson <= 18){
                    System.out.println("5$");
                } else if (ageOfPerson > 18 && ageOfPerson <= 64){
                    System.out.println("12$");
                } else if ( ageOfPerson > 64 && ageOfPerson <= 122){
                    System.out.println("10$");
                } else {
                    System.out.println("Error!");
                }
                break;
        }
    }
}
