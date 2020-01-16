package shoppingSpree;

public class Product {
    private String name;
    private double cost;

    public Product(String name, double cost) {
        this.setName(name);
        this.setCost(cost);
    }

    public String getName() {
        return this.name;
    }

    public double getCost() {
        return this.cost;
    }

    private void setName(String name) {
        Validator.validateName(name);
        this.name = name;
    }

    private void setCost(double cost) {
        Validator.validateMoney(cost);
        this.cost = cost;
    }
}
