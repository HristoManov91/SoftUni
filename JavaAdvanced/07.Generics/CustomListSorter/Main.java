package CustomListSorter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CustomList<String> list = new CustomList<String>();

        String command = scanner.nextLine();
        while (!command.equals("END")){
            String[] tokens = command.split(" ");

            switch (tokens[0]){
                case "Add":
                    list.add(tokens[1]);
                    break;
                case "Remove":
                    int indexToRemove = Integer.parseInt(tokens[1]);
                    list.remove(indexToRemove);
                    break;
                case "Contains":
                    System.out.println(list.contains(tokens[1]));
                    break;
                case "Swap":
                    int firstIndex = Integer.parseInt(tokens[1]);
                    int secondIndex = Integer.parseInt(tokens[2]);
                    list.swapElement(firstIndex , secondIndex);
                    break;
                case "Greater":
                    System.out.println(list.countGreaterThan(tokens[1]));
                    break;
                case "Max":
                    System.out.println(list.getMax());
                    break;
                case "Min":
                    System.out.println(list.getMin());
                    break;
                case "Print":
                    System.out.println(list);
                    break;
                case "Sort":
                    Sorter.sort(list);
                    break;
            }


            command = scanner.nextLine();
        }
    }
}
