import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException,
            InvocationTargetException, InstantiationException {

        Class<Reflection> clazz = Reflection.class;
        System.out.println(clazz);
        Class<? super Reflection> superclass = clazz.getSuperclass();
        System.out.println(superclass);
        Class<?>[] interfaces = clazz.getInterfaces();
        Arrays.stream(interfaces).forEach(System.out::println);
        Reflection instance = clazz.getDeclaredConstructor().newInstance();
        System.out.println(instance.toString());
    }
}
