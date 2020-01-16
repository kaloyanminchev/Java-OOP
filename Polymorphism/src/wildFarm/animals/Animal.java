package wildFarm.animals;

import wildFarm.foods.Food;

import java.text.DecimalFormat;

public abstract class Animal {
    private String name;
    private String type;
    private Double weight;
    private Integer foodEaten;

    protected Animal(String name, String type, Double weight) {
        this.name = name;
        this.type = type;
        this.weight = weight;
        this.foodEaten = 0;
    }

    protected String getName() {
        return this.name;
    }

    protected String getType() {
        return this.type;
    }

    protected Double getWeight() {
        return this.weight;
    }

    protected Integer getFoodEaten() {
        return this.foodEaten;
    }

    public abstract void makeSound();

    public void eat(Food food) {
        this.foodEaten += food.getQuantity();
    }

    @Override
    public String toString() {
        return String.format("%s[%s, %s, region, %d]",
                this.getType(),
                this.getName(),
                new DecimalFormat("#.##").format(this.getWeight()),
                this.getFoodEaten());
    }
}
