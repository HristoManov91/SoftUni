package Exercise_04_Froggy;

import java.util.Iterator;
import java.util.List;

public class Lake implements Iterable<Integer> {
    private List<Integer> numbersInLake;

    public Lake(List<Integer> numbersInLake) {
        this.numbersInLake = numbersInLake;
    }

    @Override
    public Iterator<Integer> iterator(){
        return new Iterator<Integer>() {
            private int index = 0;
            private int lastEvenIndex = numbersInLake.size() % 2 == 0 ? numbersInLake.size() - 2 : numbersInLake.size() - 1;

            @Override
            public boolean hasNext() {
                return this.index < numbersInLake.size();
            }

            @Override
            public Integer next(){
                if (this.index == lastEvenIndex){
                    int element = numbersInLake.get(lastEvenIndex);
                    this.index = 1;
                    return element;
                }
                int element = numbersInLake.get(index);
                this.index += 2;
                return element;
            }
        };
    }
}
