package CustomListSorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomList<T extends Comparable<T>> {
    private List<T> values;

    public CustomList(){
        this.values = new ArrayList<>();
    }

    public void add (T element){
        this.values.add(element);
    }

    public T remove (int index){
        if (!validIndex(index)) {
            T element = this.values.remove(index);
            return element;
        }
        throw new IndexOutOfBoundsException("Invalid index");
    }

    public boolean validIndex (int index){
        if (index < 0 || this.values.size() <= index){
            return false;
        }
        return true;
    }

    public boolean contains (T element){
        return this.values.contains(element);
    }

    public void swapElement (int firstIndex , int secondIndex){
        if (validIndex(firstIndex) || validIndex(secondIndex)){
            Collections.swap(this.values , firstIndex , secondIndex);
        }
    }

    public int countGreaterThan (T element){
        return (int) this.values.stream().filter(e -> e.compareTo(element) > 0).count();
    }

    public T getMax (){
        if (this.values.isEmpty()){
            throw new IllegalStateException("Empty list");
        }
        T maxElement = this.values.get(0);
        for (int i = 1; i < this.values.size(); i++) {
            T currentElement = this.values.get(i);
            if (currentElement.compareTo(maxElement) > 0){
                maxElement = currentElement;
            }
        }
        return maxElement;
    }

    public T getMin (){
//        return Collections.min(this.values);
        if (this.values.isEmpty()){
            throw new IllegalStateException("Empty list");
        }
        T minElement = this.values.get(0);
        for (int i = 1; i < this.values.size(); i++) {
            T currentElement = this.values.get(i);
            if (currentElement.compareTo(minElement) < 0){
                minElement = currentElement;
            }
        }
        return minElement;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T element : this.values) {
            sb.append(element).append(System.lineSeparator());
        }
        return sb.toString();
    }

    public int size (){
        return this.values.size();
    }

    public T get(int index) {
        return this.values.get(index);
    }
}
