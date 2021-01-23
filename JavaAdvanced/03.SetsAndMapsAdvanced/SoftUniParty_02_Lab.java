import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SoftUniParty_02_Lab {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> vip = new TreeSet<>();
        Set<String> normal = new TreeSet<>();

        String quest = scanner.nextLine();
        while (!quest.equals("PARTY")){
            if (Character.isDigit(quest.charAt(0))){
                vip.add(quest);
            } else {
                normal.add(quest);
            }
            quest = scanner.nextLine();
        }

        String comingQuest = scanner.nextLine();
        while (!comingQuest.equals("END")){
            if (Character.isDigit(comingQuest.charAt(0))){
                vip.remove(comingQuest);
            } else {
                normal.remove(comingQuest);
            }
            comingQuest = scanner.nextLine();
        }

        System.out.println(vip.size() + normal.size());
        for (String v : vip) {
            System.out.println(v);
        }

        for (String n : normal) {
            System.out.println(n);
        }
    }
}
