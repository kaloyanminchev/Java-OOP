package pizzaCalories;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String name;
    private Dough dough;
    private List<Topping> toppings;

    public Pizza(String name, int numberOfToppings) {
        this.setName(name);
        this.setToppings(numberOfToppings);
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        ValidatorUtil.validatePizzaName(name);
        this.name = name;
    }

    private void setToppings(int numberOfToppings) {
        ValidatorUtil.validateNumberOfToppings(numberOfToppings);
        this.toppings = new ArrayList<>(numberOfToppings);
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    public void addTopping(Topping topping) {
        this.toppings.add(topping);
    }

    public double getOverallCalories() {
        return this.dough.calculateCalories()
                + this.toppings.stream().mapToDouble(Topping::calculateCalories).sum();
    }
}
