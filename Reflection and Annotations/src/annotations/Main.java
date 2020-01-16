package annotations;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {

//        annotations.Tracker.printMethodsByAuthor(annotations.Tracker.class);
//        annotations.Author annotation = annotations.Tracker.class.getAnnotation(annotations.Author.class);
//        System.out.println(annotation.name());

        Method[] methods = Reflection.class.getDeclaredMethods();
        Arrays.stream(methods)
                .filter(m -> m.isAnnotationPresent(Author.class))
                .sorted(Comparator.comparing(Method::getName))
                .forEach(m -> System.out.println(m.getName() + " has annotation " + Author.class.getName()));
    }
}
