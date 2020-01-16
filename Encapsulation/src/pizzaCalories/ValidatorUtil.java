package pizzaCalories;

public class ValidatorUtil {

    public static void validatePizzaName(String name) {
        if (name == null || name.trim().isEmpty() || name.length() > 15) {
            throw new IllegalArgumentException("pizzaCalories.Pizza name should be between 1 and 15 symbols.");
        }
    }

    public static void validateNumberOfToppings(int numberOfToppings) {
        if (numberOfToppings < 0 || numberOfToppings > 10) {
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }
    }

    public static void validateFlour(String flourType) {
        if (!validateFlourType(flourType)) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
    }

    private static boolean validateFlourType(String flourType) {
        return flourType.equals("White")
                || flourType.equals("Wholegrain");
    }

    public static void validateBakingTechnique(String bakingTechnique) {
        if (!validateTechnique(bakingTechnique)) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
    }

    private static boolean validateTechnique(String bakingTechnique) {
        return bakingTechnique.equals("Crispy")
                || bakingTechnique.equals("Chewy")
                || bakingTechnique.equals("Homemade");
    }

    public static void validateDoughWeight(double weight) {
        if (weight < 1 || weight > 200) {
            throw new IllegalArgumentException("pizzaCalories.Dough weight should be in the range [1..200].");
        }
    }

    public static void validateTopping(String topping) {
        if (!validateToppingType(topping)) {
            throw new IllegalArgumentException(String.format("Cannot place %s on top of your pizza.", topping));
        }
    }

    private static boolean validateToppingType(String topping) {
        return topping.equals("Meat")
                || topping.equals("Veggies")
                || topping.equals("Cheese")
                || topping.equals("Sauce");
    }

    public static void validateToppingWeight(double weight, String topping) {
        if (weight < 1 || weight > 50) {
            throw new IllegalArgumentException(
                    String.format("%s weight should be in the range [1..50].", topping));
        }
    }
}
