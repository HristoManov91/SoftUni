import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Pokemon {

    public static List<Integer> calculation (int number , List<Integer> list){
        List<Integer> newList = list;
        for (int i = 0; i < newList.size(); i++) {
            if (newList.get(i) <= number) {
                newList.set(i, number + newList.get(i));
            } else {
                newList.set(i, newList.get(i) - number);
            }
        }
        return newList;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> list = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> removedElements = new ArrayList<>();

        while (!list.isEmpty()) {
            int index = Integer.parseInt(scan.nextLine());
            int removeNumber = Integer.MAX_VALUE;

            if (index < 0) {
                removeNumber = list.get(0);
                removedElements.add(list.get(0));
                list.remove(0);
                list.add(0, list.get(list.size() - 1));
                list = calculation(removeNumber , list);
            }
            else if (index > list.size() - 1) {
                removeNumber = list.get(list.size() - 1);
                removedElements.add(list.get(list.size() - 1));
                list.remove(list.size() - 1);
                list.add(list.get(0));
                list = calculation(removeNumber , list);
            } else {
                removeNumber = list.get(index);
                removedElements.add(removeNumber);
                list.remove(index);
                if (list.size() > 0) {
                    list = calculation(removeNumber, list);
                }
            }
        }
        int sum = 0;
        for (int num: removedElements) {
            sum += num;
        }
        System.out.println(sum);
    }
}
