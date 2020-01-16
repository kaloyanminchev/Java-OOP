package borderControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Identifiable> identifiables = new ArrayList<>();

        String input;
        while (!"End".equals(input = scanner.nextLine())) {
            String[] tokens = input.split("\\s+");
            Identifiable identifiable;

            if (tokens.length == 3) {
                identifiable = new Citizen(tokens[0],
                        Integer.parseInt(tokens[1]),
                        tokens[2]);
            } else {
                identifiable = new Robot(tokens[0], tokens[1]);
            }

            identifiables.add(identifiable);
        }

        String lastDigits = scanner.nextLine();

        for (Identifiable identifiable : identifiables) {
            if (identifiable.getId().endsWith(lastDigits)) {
                System.out.println(identifiable.getId());
            }
        }
    }
}
