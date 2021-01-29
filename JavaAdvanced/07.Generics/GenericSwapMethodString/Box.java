package GenericSwapMethodString;

import java.util.ArrayList;
import java.util.List;

public class Box<T> {
    private List<T> values;

    public Box(){
        this.values = new ArrayList<>();
    }

    public void addElement (T element){
        this.values.add(element);
    }

    public void swapElements (int fromIndex , int toIndex){
        T firstElement = this.values.get(fromIndex);
        T secondElement = this.values.get(toIndex);

        values.set(fromIndex , secondElement);
        values.set(toIndex , firstElement);
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
