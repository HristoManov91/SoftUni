package CustomListSorter;

public class Sorter<T extends Comparable<T>> {

    public static <T extends Comparable<T>> void sort (CustomList<T> customList){
        for (int i = 0; i < customList.size(); i++) {
            String element = (String) customList.get(i);
            for (int j = i + 1; j < customList.size(); j++) {
                String nextElement = (String) customList.get(j);
                if (element.compareTo(nextElement) > 0){
                    customList.swapElement(i , j);
                }
            }
        }
    }
}
