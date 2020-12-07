import java.util.Scanner;

public class WorldTour {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder travelStops = new StringBuilder(scanner.nextLine());

        String input = scanner.nextLine();
        while (!input.equals("Travel")) {
            String[] tokens = input.split(":");
            String command = tokens[0];
            switch (command) {
                case "Add Stop":
                    int indexToInsert = Integer.parseInt(tokens[1]);
                    if (isValidIndex(travelStops , indexToInsert)) {
                        String travelStop = tokens[2];
                        travelStops.insert(indexToInsert, travelStop);
                    }
                    break;
                case "Remove Stop":
                    int fromIndex = Integer.parseInt(tokens[1]);
                    int toIndex = Integer.parseInt(tokens[2]);
                    if (isValidIndex(travelStops , fromIndex) && isValidIndex(travelStops , toIndex)) {
                        travelStops.delete(fromIndex, toIndex + 1);
                    }
                    break;
                case "Switch":
                    String oldString = tokens[1];
                    String newString = tokens[2];
                    travelStops = new StringBuilder(travelStops.toString().replace(oldString, newString));
                    break;
            }
            System.out.println(travelStops);
            input = scanner.nextLine();
        }
        System.out.println("Ready for world tour! Planned stops: " + travelStops.toString());
    }
    static boolean isValidIndex (StringBuilder s , int index){
        return index >= 0 && index < s.length();
    }
}
