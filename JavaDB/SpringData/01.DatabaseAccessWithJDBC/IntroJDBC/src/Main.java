import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        Homework homework = new Homework();
        homework.setConnection("root" , "12345");


        System.out.println("Enter number of task you want to test:");
        String input = scanner.nextLine();
        while (!input.equals("Stop")) {
            int numberOfTask = Integer.parseInt(input);
            switch (numberOfTask) {
                case 2:
                    homework.getVillainsNameEx2();
                    break;
                case 3:
                    homework.getMinionsNamesByVillainsIdEx3();
                    break;
                case 4:
                    homework.addMinionInDatabaseEx4();
                    break;
                case 5:
                    homework.changeTownNameCasingEx5();
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    homework.increaseMinionsAgeEx8();
                    break;
                case 9:
                    homework.increaseMinionsAgeWithStoreProcedureEx9();
                    break;
                default:
                    System.out.printf("We don't have a task with number %s." +
                            "Please enter valid number of task from 2 to 9%n", input);
            }
            System.out.println("Enter number of task you want to test or Stop:");
            input = scanner.nextLine();
        }
        System.out.println("Thank you :)");
    }
}
