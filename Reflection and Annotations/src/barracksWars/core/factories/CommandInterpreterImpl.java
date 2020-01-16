package barracksWars.core.factories;

import barracksWars.interfaces.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class CommandInterpreterImpl implements CommandInterpreter {
    private static final String COMMAND_PACKAGE = "barracksWars.core.commands.";

    private Repository repository;
    private UnitFactory unitFactory;

    public CommandInterpreterImpl(Repository repository, UnitFactory unitFactory) {
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    @Override
    public Executable interpretCommand(String[] data, String commandName) {
        String command = getCorrectClass(data[0]);

        Executable executable = null;
        try {
            Class<?> clazz = Class.forName(COMMAND_PACKAGE + command);
            Constructor<?> constructor = clazz.getDeclaredConstructor(String[].class);
            executable = (Executable) constructor.newInstance(new Object[]{data});

            populateDependencies(executable);

        } catch (ClassNotFoundException |
                NoSuchMethodException |
                IllegalAccessException |
                InstantiationException |
                InvocationTargetException e) {
        }

        return executable;
    }

    private void populateDependencies(Executable executable) {
        Field[] exeFields = executable.getClass().getDeclaredFields();
        Field[] currentClassFields = this.getClass().getDeclaredFields();

        for (Field requiredField : exeFields) {
            Injection annotation = requiredField.getAnnotation(Injection.class);

            for (Field currentClassField : currentClassFields) {
                if (currentClassField.getType().equals(requiredField.getType())) {
                    requiredField.setAccessible(true);
                    try {
                        requiredField.set(executable, currentClassField.get(this));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }

        }

    }

    private String getCorrectClass(String name) {
        return Character.toUpperCase(name.charAt(0))
                + name.substring(1);
    }
}
