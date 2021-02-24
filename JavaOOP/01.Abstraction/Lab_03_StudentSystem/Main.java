package Lab_03_StudentSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentSystem studentSystem = new StudentSystem();

        String input = scanner.nextLine();
        while (!input.equals("Exit")) {
            String[] tokens = input.split(" ");
            if (tokens[0].equals("Create")){
                Student student = new Student(tokens[1] , Integer.parseInt(tokens[2]) , Double.parseDouble(tokens[3]));
                studentSystem.getRepo().putIfAbsent(student.getName() , student);
            } else if (tokens[0].equals("Show") && studentSystem.getRepo().containsKey(tokens[1])){
                studentSystem.printStudent(tokens[1]);
            }
            input = scanner.nextLine();
        }
    }
}
