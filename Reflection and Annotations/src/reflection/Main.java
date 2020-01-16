package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Class someClass = Reflection.class;
        System.out.println(someClass);

        System.out.println(someClass.getSuperclass());

        Class[] interfaces = someClass.getInterfaces();
        Arrays.stream(interfaces)
                .forEach(System.out::println);

        Constructor[] declaredConstructors = someClass.getDeclaredConstructors();
        Reflection reflection = (Reflection) someClass.getConstructor().newInstance();

        System.out.println(reflection);

    }
}
