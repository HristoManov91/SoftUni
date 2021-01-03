package GenericCountMethodStrings;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Comparable<T>> {
    private List<T> values;

    public Box(){
        this.values = new ArrayList<>();
    }

    public void addElement (T element){
        this.values.add(element);
    }

    public int countGreaterThan (T element){
        int count = (int) this.values.stream().filter(e -> e.compareTo(element) > 0).count();
        return count;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T value : values) {
            sb.append(String.format("%s: %s", value.getClass().getName() , value));
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }
}
