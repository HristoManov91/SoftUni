import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException,
            InvocationTargetException, InstantiationException {

        Class<Reflection> clazz = Reflection.class;

        Method[] declaredMethods = clazz.getDeclaredMethods();

        Set<Method> getters = new TreeSet<>(new MethodComparatorByName());

        Set<Method> setters = new TreeSet<>(new MethodComparatorByName());

        for (Method method : declaredMethods) {
            if (method.getName().startsWith("get")) {
                getters.add(method);
            } else if (method.getName().startsWith("set")) {
                setters.add(method);
            }
        }

        System.out.println(getters.stream()
                .map(g -> g.getName() + " will return class "
                        + g.getReturnType().getName().replace("class" , ""))
                .collect(Collectors.joining(System.lineSeparator())));
        System.out.println(setters.stream()
                .map(s -> s.getName() + " and will set field of class "
                        + s.getParameterTypes()[0].getName().replace("class" , ""))
                .collect(Collectors.joining(System.lineSeparator())));
    }

    public static class MethodComparatorByName implements Comparator<Method> {

        @Override
        public int compare(Method first, Method second) {
            return first.getName().compareTo(second.getName());
        }
    }
}
