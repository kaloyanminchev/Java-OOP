package shoppingSpree;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        this.setName(name);
        this.setMoney(money);
        this.products = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        Validator.validateName(name);
        this.name = name;
    }

    private void setMoney(double money) {
        Validator.validateMoney(money);
        this.money = money;
    }

    public void buyProduct(Product product) {
        double cost = product.getCost();
        if (this.money >= cost) {
            products.add(product);
            this.money -= cost;
        } else {
            throw new IllegalStateException(String.format("%s can't afford %s",
                    this.getName(),
                    product.getName())
            );
        }
    }

    @Override
    public String toString() {
        String output = "Nothing bought";

        if (!this.products.isEmpty()) {
            output = this.products.stream()
                    .map(Product::getName)
                    .collect(Collectors.joining(", "));
        }

        return this.getName() + " - " + output;
    }
}
