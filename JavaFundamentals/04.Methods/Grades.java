import java.util.Scanner;

public class Grades {

    static void printWordByGrades (double grade){
        if (2 <= grade && grade < 3){
            System.out.println("Fail");
        } else if (3 <= grade && grade < 3.5){
            System.out.println("Poor");
        } else if (3.5 <= grade && grade < 4.5){
            System.out.println("Good");
        } else if (4.5 <= grade && grade < 5.5){
            System.out.println("Very good");
        } else if (5.5 <= grade && grade <= 6){
            System.out.println("Excellent");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double grade = Double.parseDouble(scanner.nextLine());
        printWordByGrades(grade);
    }
}
