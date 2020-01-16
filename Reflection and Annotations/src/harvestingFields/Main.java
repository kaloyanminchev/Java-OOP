package harvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Class richSoilLandClass = RichSoilLand.class;

        Field[] fields = richSoilLandClass.getDeclaredFields();

        String command = scanner.nextLine();
        while (!command.equals("HARVEST")) {

            for (Field field : fields) {
                String modifier = Modifier.toString(field.getModifiers());

                if (modifier.equals(command) || command.equals("all")) {
                    System.out.println(String.format("%s %s %s",
                            modifier,
                            field.getType().getSimpleName(),
                            field.getName()));
                }
            }

            command = scanner.nextLine();
        }
    }
}
