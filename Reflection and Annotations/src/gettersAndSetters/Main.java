package gettersAndSetters;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException {

        Class<Reflection> reflectionClass = Reflection.class;
        Method[] allDeclaredMethods = reflectionClass.getDeclaredMethods();

        Method[] getters = Arrays.stream(allDeclaredMethods)
                .filter(m -> m.getName().startsWith("get") && m.getParameterCount() == 0)
                .toArray(Method[]::new);

        Method[] setters = getMethodsStartsWith("set", allDeclaredMethods);

        Arrays.stream(getters)
                .sorted(Comparator.comparing(Method::getName))
                .forEach(g -> System.out.println(
                        String.format("%s will return class %s",
                                g.getName(),
                                g.getReturnType().getName())
                        )
                );

        Arrays.stream(setters)
                .sorted(Comparator.comparing(Method::getName))
                .forEach(g -> System.out.println(
                        String.format("%s and will set field of class %s",
                                g.getName(),
                                g.getParameterTypes()[0].getName())
                        )
                );
    }

    public static Method[] getMethodsStartsWith(String with, Method[] methods) {
        return Arrays.stream(methods)
                .filter(m -> m.getName().startsWith(with))
                .toArray(Method[]::new);
    }
}
