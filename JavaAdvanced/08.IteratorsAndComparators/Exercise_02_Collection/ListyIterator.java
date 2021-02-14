package Exercise_02_Collection;

import java.util.Iterator;
import java.util.List;

public class ListyIterator implements Iterable<String> {
    private List<String> list;
    private int index;

    public ListyIterator(List<String> list) {
        this.list = list;
        if (this.list.size() == 0) {
            this.index = -1;
        }
    }

    public boolean move() {
        if (this.index < this.list.size() - 1){
            index++;
            return true;
        }
        return false;
    }

    public void print(){
        if (index == -1){
            System.out.println("Invalid Operation!");
        } else {
            System.out.println(list.get(index));
        }
    }

    public boolean hasNext(){
        return index + 1 < list.size();
    }


    @Override
    public Iterator<String> iterator() {
        return new Iterator<>() {
            private int index = 0;
            @Override
            public boolean hasNext() {
                return this.index <= list.size() - 1;
            }

            @Override
            public String next() {
                return list.get(this.index++);
            }
        };
    }
}
