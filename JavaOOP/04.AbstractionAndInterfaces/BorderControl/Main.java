package BorderControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Identifiable> identifiables = new ArrayList<>();

        String input = scanner.nextLine();
        while (!input.equals("End")){
            String[] data = input.split("\\s+");
            if (data.length == 2){
                identifiables.add(new Robot(data[0] , data[1]));
            } else if (data.length == 3){
                identifiables.add(new Citizen(data[0] , Integer.parseInt(data[1]) , data[2]));
            }
            input = scanner.nextLine();
        }
        String fakeId = scanner.nextLine();
        for (Identifiable identifiable : identifiables) {
            if (identifiable.getId().endsWith(fakeId)){
                System.out.println(identifiable.getId());
            }
        }
    }
}
