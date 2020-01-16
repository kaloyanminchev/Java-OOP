import core.ManagerControllerImpl;
import core.interfaces.ManagerController;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ManagerController controller = new ManagerControllerImpl();

        String input = scanner.nextLine();
        while (!"Exit".equals(input)) {
            String[] tokens = input.split("\\s+");
            String result = "";
            try {

                switch (tokens[0]) {
                    case "AddPlayer":
                        result = controller.addPlayer(tokens[1], tokens[2]);
                        break;
                    case "AddCard":
                        result = controller.addCard(tokens[1], tokens[2]);
                        break;
                    case "AddPlayerCard":
                        result = controller.addPlayerCard(tokens[1], tokens[2]);
                        break;
                    case "Fight":
                        result = controller.fight(tokens[1], tokens[2]);
                        break;
                    case "Report":
                        result = controller.report();
                        break;
                }

                System.out.println(result);

            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
            input = scanner.nextLine();
        }
    }
}
