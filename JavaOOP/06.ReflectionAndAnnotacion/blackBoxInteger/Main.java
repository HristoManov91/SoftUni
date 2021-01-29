package blackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Class<BlackBoxInt> clazz = BlackBoxInt.class;
        //instance на класа я вадим извън try/catch блока,за да е видима извън него
        BlackBoxInt instance;

        try {
            //взимам конструктора на класа като му подаваме и параметър
            Constructor<BlackBoxInt> ctor = clazz.getDeclaredConstructor(int.class);
            ctor.setAccessible(true);//понеже е private му давам достъп с true
            instance = ctor.newInstance(0);//създавам нова инстанция от него
        } catch (NoSuchMethodException //всички exception ги слагаме в try/catch блока
                | IllegalAccessException
                | InstantiationException
                | InvocationTargetException e) {
            throw new IllegalStateException(e);
        }
        Method[] methods = clazz.getDeclaredMethods();//взимам всички методи от класа

        String input = scanner.nextLine();
        while (!input.equals("END")) {
            String command = input.split("_")[0];
            int param = Integer.parseInt(input.split("_")[1]);
            try {
                //създаваме променлива която от този клас взима метода с името от входа и с параметъра който приема
                Method method = clazz.getDeclaredMethod(command, int.class);
                method.setAccessible(true); // даваме му достъп защото е private
                method.invoke(instance , param);//извикваме метода върху инстанцията от този обект с параметъра от входа
                //взимаме си полето,което трябва да принтираме всеки път
                Field field = clazz.getDeclaredField("innerValue");
                field.setAccessible(true);//даваме достъп до него
                System.out.println(field.get(instance));//вземи стойността на полето от инстанция от този обект
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | NoSuchFieldException e) {
                throw new IllegalStateException(e);
            }
            input = scanner.nextLine();
        }
    }
}
