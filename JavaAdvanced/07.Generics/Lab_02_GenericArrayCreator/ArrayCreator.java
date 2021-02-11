package Lab_02_GenericArrayCreator;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayCreator {

    String[] strings = create(10, "none");
    Integer[] integers = create(Integer.class, 10, 0);

    public static <T> T[] create(int length , T item){
        T[] arr = (T[]) Array.newInstance(item.getClass() , length);
        Arrays.fill(arr , item);
        return arr;
    }

    public static <T> T[] create(Class<T> clazz , int length , T item){
        T[] arr = (T[]) Array.newInstance(clazz , length);
        Arrays.fill(arr , item);
        return arr;
    }


}
