package GenericArrayCreator;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class ArrayCreator {

    String[] strings = create(10, "none");
    Integer[] integers = create(Integer.class, 10, 0);

    //String[] elements = create(12 , "elements");
    //това е статичен метод и мога да го достъпя чрез референция на името на класа (Scale.Main.) и мога да му подам
    //типизираният параметър (<String>) пред метода (create)
    //Но понеже може да види от ляво какво има (String[]) е излишно да го пишем след Scale.Main.
    //String[] elements2 = Scale.Main.create(12 , "elements");

    public static <T> T[] create(int length, T item) {
        T[] array = (T[])Array.newInstance(item.getClass(), length);
        Arrays.fill(array , item);
        return (T[]) array;
    }

    public static <T> T[] create(Class<T> clazz, int length, T item) {
        T[] array = (T[]) Array.newInstance(clazz, length);
        Arrays.fill(array , item);
        return array;
    }
}
//Всеки един статичен метод който искам да създам и искам да се използва с различни типове(generic) трябва да
//напиша типа с който ще работи преди return (T[]) типа
//@SuppressWarnings("unchecked")//така премахва мрънкането при кастването на arr2 при return като сме сигорни че
// тази операция е ОК
//public static <T> T[] create (int length , T element){
//Неможем да вдигнем една инстанция на масив от типа T защото на практика такъв тип не съществува.Това което трябва
//да направим е да го вдигнем от Object[] и да го type cast(конвертираме) към Т[]
//T[] arr = (T[]) new Object[length];
//за да работи обаче е правилно така да се напише с Array.newInstance и да го каснем при return-a;
//Object arr2 = Array.newInstance(element.getClass() , length);

//return (T[]) arr2;
//}

//    public static <T> T[] create (Class<T> clazz , int length , T item){
//        //create(length , item);//кратък вариянт е да извикаме горният метод който сме създали
//        return (T[])Array.newInstance(clazz , length);//може и по този начин
//    }

