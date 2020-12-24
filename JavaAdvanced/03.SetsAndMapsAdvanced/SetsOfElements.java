import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> firstSet = new LinkedHashSet<>();
        Set<String> secondSet = new LinkedHashSet<>();
        int lengthFirstSet = scanner.nextInt();
        int lengthSecondSet = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < lengthFirstSet; i++) {
            String num = scanner.nextLine();
            firstSet.add(num);
        }

        for (int i = 0; i < lengthSecondSet; i++) {
            String num = scanner.nextLine();
            secondSet.add(num);
        }
        firstSet.retainAll(secondSet);//така проверяваме 2 сета кои са общите им елементи като които се повтарят ги
        //запазва в първият сет и премахва всички които не се повтарят

//        Set<String> output = new LinkedHashSet<>();
//        for (String n : firstSet) {
//            if (secondSet.contains(n)) {
//                output.add(n);
//            }
//        }
        System.out.println(String.join(" ", firstSet));
    }
}
