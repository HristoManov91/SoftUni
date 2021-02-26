package StudentSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentSystem studentSystem = new StudentSystem();

        String input = scanner.nextLine();
        while (!input.equals("Exit")) {
            String[] data = input.split(" ");
            if (data[0].equals("Create")){
                Student student = new Student(data[1] , Integer.parseInt(data[2]) , Double.parseDouble(data[3]));
                studentSystem.getRepo().putIfAbsent(student.getName() , student);
            } else if (data[0].equals("Show") && studentSystem.getRepo().containsKey(data[1])){
                Student studentToPrint = studentSystem.getRepo().get(data[1]);
                System.out.println(studentToPrint.toString());
            }

            input = scanner.nextLine();
        }
    }
}
