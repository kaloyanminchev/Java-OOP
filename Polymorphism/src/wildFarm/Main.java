package wildFarm;

import wildFarm.animals.*;
import wildFarm.foods.Food;
import wildFarm.foods.Meat;
import wildFarm.foods.Vegetable;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Animal> animals = new ArrayList<>();

        String input = scanner.nextLine();

        while (!input.equals("End")) {
            String[] animalTokens = input.split("\\s+");

            String[] foodTokens = scanner.nextLine().split("\\s+");

            Animal animal = produceAnimal(animalTokens);

            Food food = produceFood(foodTokens);

            animal.makeSound();

            try {
                animal.eat(food);
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }

            animals.add(animal);

            input = scanner.nextLine();
        }

        for (Animal animal : animals) {
            System.out.println(animal.toString());
        }
    }

    private static Animal produceAnimal(String[] animalTokens) {
        String type = animalTokens[0];
        String name = animalTokens[1];
        Double weight = Double.parseDouble(animalTokens[2]);
        String livingRegion = animalTokens[3];

        Animal animal = null;
        switch (type) {
            case "Cat":
                animal = new Cat(name, type, weight, livingRegion, animalTokens[4]);
                break;
            case "Tiger":
                animal = new Tiger(name, type, weight, livingRegion);
                break;
            case "Zebra":
                animal = new Zebra(name, type, weight, livingRegion);
                break;
            case "Mouse":
                animal = new Mouse(name, type, weight, livingRegion);
                break;
        }

        return animal;
    }

    private static Food produceFood(String[] foodTokens) {
        String type = foodTokens[0];
        Integer quantity = Integer.parseInt(foodTokens[1]);

        Food food = null;
        if (type.equals("Meat")) {
            food = new Meat(quantity);
        } else if (type.equals("Vegetable")) {
            food = new Vegetable(quantity);
        }

        return food;
    }
}
