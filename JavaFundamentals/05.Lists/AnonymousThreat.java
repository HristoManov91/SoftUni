import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AnonymousThreat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> arr = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());

        String input = scanner.nextLine();
        while (!input.equals("3:1")) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            switch (command) {
                case "merge":
                    int startIndex = Integer.parseInt(tokens[1]);
                    if (startIndex < 0) {
                        startIndex = 0;
                    }
                    int endIndex = Integer.parseInt(tokens[2]);
                    if (endIndex > arr.size() - 1) {
                        endIndex = arr.size() - 1;
                    }
                    if (startIndex < arr.size() - 1 && endIndex >= 0) {
                        String newElement = "";
                        for (int i = startIndex; i <= endIndex; i++) {
                            newElement = newElement.concat(arr.get(i));
                        }
                        arr.set(startIndex, newElement);
                        arr.subList(startIndex + 1, endIndex + 1).clear();
//                        for (int i = endIndex; i > startIndex ; i--) {
//                            arr.remove(i);
//                        }
                    }
                    break;
                case "divide":
                    int index = Integer.parseInt(tokens[1]);
                    int partitions = Integer.parseInt(tokens[2]);
                    int countElements = arr.get(index).length() / partitions;
                    String[] temp = new String[countElements];
                    int count = 0;
                    for (int j = 0; j < arr.get(index).length(); j += 2) {

                        String part = arr.get(index).substring(j, j + 2);
                        temp[count] = part;
                        count++;
                    }
                    arr.remove(index);
                    for (int i = temp.length - 1; i >= 0; i--) {
                        arr.add(index, temp[i]);
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.println(arr.toString().replaceAll("[\\[\\],]", ""));
    }
}
