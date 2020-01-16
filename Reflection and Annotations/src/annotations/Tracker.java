package annotations;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tracker {

    @Author(name = "Peter")
    public static void printMethodsByAuthor(Class<Tracker> trackerClass) {
        Map<String, List<String>> methodsByAuthor = new HashMap<>();
        Method[] methods = trackerClass.getDeclaredMethods();

        for (Method method : methods) {
            Author annotation = method.getAnnotation(Author.class);
            boolean annotationPresent = method.isAnnotationPresent(Author.class);
            if (annotationPresent) {
                methodsByAuthor
                        .putIfAbsent(annotation.name(), new ArrayList<>());

                methodsByAuthor
                        .get(annotation.name()).add(method.getName() + "()");
            }
        }

        methodsByAuthor.forEach((k, v) -> System.out.println(k + ": " + v));
    }
}
