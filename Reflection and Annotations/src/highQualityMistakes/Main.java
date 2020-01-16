package highQualityMistakes;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {

        Class reflectionClass = Reflection.class;
        Field[] declaredFields = reflectionClass.getDeclaredFields();

        Arrays.stream(declaredFields)
                .filter(field -> !Modifier.isPrivate(field.getModifiers()))
                .sorted(Comparator.comparing(Field::getName))
                .forEach(f -> System.out.println(f.getName() + " must be private!"));

        Method[] allDeclaredMethods = reflectionClass.getDeclaredMethods();

        Arrays.stream(allDeclaredMethods)
                .filter(g -> g.getName().startsWith("get") && g.getParameterCount() == 0 && !Modifier.isPublic(g.getModifiers()))
                .sorted(Comparator.comparing(Method::getName))
                .forEach(getter -> System.out.println(getter.getName() + " have to be public!"));

        Arrays.stream(allDeclaredMethods)
                .filter(s -> s.getName().startsWith("set") && !Modifier.isPrivate(s.getModifiers()))
                .sorted(Comparator.comparing(Method::getName))
                .forEach(setter -> System.out.println(setter.getName() + " have to be private!"));
    }
}
