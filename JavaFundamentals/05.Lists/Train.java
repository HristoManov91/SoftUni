import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> peopleInWagons = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int maxPeopleInWagon = Integer.parseInt(scanner.nextLine());

        String input = scanner.nextLine();
        while (!input.equals("end")){
            String[] tokens = input.split(" ");
            if (tokens[0].equals("Add")){
                int passengersInNewWagon = Integer.parseInt(tokens[1]);
                peopleInWagons.add(passengersInNewWagon);
            } else {
                int newPassenger = Integer.parseInt(tokens[0]);
                for (int i = 0; i < peopleInWagons.size(); i++) {
                    if (peopleInWagons.get(i) + newPassenger <= maxPeopleInWagon){
                        peopleInWagons.set(i , peopleInWagons.get(i) + newPassenger);
                        break;
                    }
                }
            }
            input = scanner.nextLine();
        }
        System.out.println(peopleInWagons.toString().replaceAll("[\\[\\],]", ""));
    }
}
