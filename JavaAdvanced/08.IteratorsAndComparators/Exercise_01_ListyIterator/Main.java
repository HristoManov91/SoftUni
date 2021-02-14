package Exercise_01_ListyIterator;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> input = Arrays.stream(scanner.nextLine().split(" ")).skip(1).collect(Collectors.toList());
        ListyIterator listyIterator = new ListyIterator(input);

        String command = scanner.nextLine();
        while (!command.equals("End")){
            switch (command){
                case "Move":
                    System.out.println(listyIterator.move());
                    break;
                case "Print":
                    listyIterator.print();
                    break;
                case "HasNext":
                    System.out.println(listyIterator.hasNext());
                    break;
            }
            command = scanner.nextLine();
        }
    }
}
