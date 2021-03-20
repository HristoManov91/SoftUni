package blackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        Scanner scanner = new Scanner(System.in);

        Constructor<BlackBoxInt> ctor = BlackBoxInt.class.getDeclaredConstructor();
        ctor.setAccessible(true);
        BlackBoxInt blackBoxInt = ctor.newInstance();

        Method[] methods = blackBoxInt.getClass().getDeclaredMethods();
        Field field = blackBoxInt.getClass().getDeclaredField("innerValue");
        field.setAccessible(true);

        String line = scanner.nextLine();
        while (!line.equals("END")){
            String[] tokens = line.split("_");
            String command = tokens[0];
            int param = Integer.parseInt(tokens[1]);

            Method method = Arrays.stream(methods).filter(m -> m.getName().equals(command)).findFirst().get();
            method.setAccessible(true);
            method.invoke(blackBoxInt , param);

            System.out.println(field.getInt(blackBoxInt));
            line = scanner.nextLine();
        }
    }
}
