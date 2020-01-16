package pizzaCalories;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split("\\s+");

        try {
            Pizza pizza = new Pizza(tokens[1], Integer.parseInt(tokens[2]));

            tokens = scanner.nextLine().split("\\s+");
            Dough dough = new Dough(tokens[1], tokens[2], Double.parseDouble(tokens[3]));

            pizza.setDough(dough);

            String input = scanner.nextLine();
            while (!input.equals("END")) {
                tokens = input.split("\\s+");

                Topping topping = new Topping(tokens[1], Double.parseDouble(tokens[2]));
                pizza.addTopping(topping);

                input = scanner.nextLine();
            }

            System.out.println(String.format("%s - %.2f",
                    pizza.getName(),
                    pizza.getOverallCalories())
            );

        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
