package Exercise_01_ListyIterator;

import java.util.List;

public class ListyIterator {
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
}
