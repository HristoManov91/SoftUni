package Lab_04_RandomArrayList;

import java.util.ArrayList;
import java.util.Random;

public class RandomArrayList <T> extends ArrayList<T> {
    private Random random;

    public RandomArrayList(){
        this.random = new Random();
    }

    public Object getRandomElement(){
        int index = this.random.nextInt(super.size());
        return this.get(index);
    }
}
