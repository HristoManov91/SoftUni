package ListUtilities;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        list.add(13);
        list.add(14);
        list.add(15);

        System.out.println(ListUtils.getMin(list));
        System.out.println(ListUtils.getMax(list));
        list.clear();
        System.out.println(ListUtils.getMax(list));
        System.out.println(ListUtils.getMin(list));

        System.out.println();
    }
}
