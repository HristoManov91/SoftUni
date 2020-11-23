import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SoftUniCoursePlanning {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> program = Arrays.stream(scan.nextLine().split(", "))
                .collect(Collectors.toList());

        String input = scan.nextLine();
        while (!"course start".equals(input)){
            String[] command = input.split(":");
            String lesson = command[1];
            switch (command[0]){
                case "Add":
                    if (!program.contains(lesson)){
                        program.add(lesson);
                    }
                    break;
                case "Insert":
                    int index = Integer.parseInt(command[2]);
                    if (!program.contains(lesson)){
                        if ( index >= 0 && index < program.size()){
                            program.add(index , lesson);
                        }
                    }
                    break;
                case "Remove":
                    if (program.contains(lesson)){
                        program.remove(lesson);
                        if (program.contains(lesson+"-Exercise")){
                            program.remove(lesson+"-Exercise");
                        }
                    }
                    break;
                case "Swap":
                    String swappedLesson = command[2];
                    if (program.contains(lesson) && program.contains(swappedLesson)){
                        int indexLesson = program.indexOf(lesson);
                        int indexSwappedLesson = program.indexOf(swappedLesson);
                        String token = program.get(indexLesson);
                        program.set(indexLesson , swappedLesson);
                        program.set(indexSwappedLesson , lesson);
                        if ( program.contains(lesson+"-Exercise")){
                            int indexExercise = program.indexOf(lesson+"-Exercise");
                            program.add(indexSwappedLesson + 1, program.get(indexExercise));
                            program.remove(indexExercise);
                        }
                        if ( program.contains(swappedLesson+"-Exercise")){
                            int indexSwappedExercise = program.indexOf(swappedLesson+"-Exercise");
                            program.add(indexLesson + 1, program.get(indexSwappedExercise));
                            program.remove(indexSwappedExercise + 1);
                        }
                    }
                    break;
                case "Exercise":
                    String exercise = lesson + "-Exercise";
                    if (program.contains(lesson)){
                        if (!program.contains(exercise)){
                            int indexLesson = program.indexOf(lesson);
                            program.add(indexLesson + 1, exercise);
                        }
                    } else {
                        program.add(lesson);
                        program.add(exercise);
                    }
                    break;
            }
            input = scan.nextLine();
        }
        for (int i = 0; i < program.size(); i++) {
            System.out.printf("%d.%s%n",i + 1, program.get(i));
        }
    }
}
