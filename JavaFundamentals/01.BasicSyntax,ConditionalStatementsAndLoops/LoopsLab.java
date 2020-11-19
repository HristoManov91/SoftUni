import java.util.Scanner;

public class LoopsLab {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int tabs = Integer.parseInt(scan.nextLine());
        int salary = Integer.parseInt(scan.nextLine());

        for (int i = 1; i <= tabs ; i++) {
            String site = scan.nextLine();
            switch (site){
                case "Facebook":
                    salary -= 150;
                    break;
                case "Instagram":
                    salary -= 100;
                    break;
                case "Reddit":
                    salary -= 50;
                    break;
            }
            if ( salary <= 0 ){
                System.out.println("You have lost your salary.");
                i = tabs + 1;
            }
        }
        if ( salary > 0 ){
            System.out.printf("%d", salary);
        }
    }
}
