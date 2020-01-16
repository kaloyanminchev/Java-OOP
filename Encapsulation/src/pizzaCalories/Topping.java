package pizzaCalories;

public class Topping {
    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
        this.setToppingType(toppingType);
        this.setWeight(weight);
    }

    public void setToppingType(String toppingType) {
        ValidatorUtil.validateTopping(toppingType);
        this.toppingType = toppingType;
    }

    public void setWeight(double weight) {
        ValidatorUtil.validateToppingWeight(weight, this.toppingType);
        this.weight = weight;
    }

    public double calculateCalories() {
        double modifier = 0;
        switch (this.toppingType) {
            case "Meat":
                modifier = 1.2;
                break;
            case "Veggies":
                modifier = 0.8;
                break;
            case "Cheese":
                modifier = 1.1;
                break;
            case "Sauce":
                modifier = 0.9;
                break;
        }

        return (2 * this.weight) * modifier;
    }
}
