package animals;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Animal> animals = new ArrayList<>();

        String input = scanner.nextLine();
        while (!input.equals("Beast!")) {
            String animalType = input;
            String[] tokens = scanner.nextLine().split(" ");

            Animal animal = null;
            try {
                switch (animalType) {
                    case "Dog":
                        animal = new Dog(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);
                        break;
                    case "Frog":
                        animal = new Frog(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);
                        break;
                    case "Cat":
                        animal = new Cat(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);
                        break;
                    case "Kitten":
                        animal = new Kitten(tokens[0], Integer.parseInt(tokens[1]));
                        break;
                    case "Tomcat":
                        animal = new Tomcat(tokens[0], Integer.parseInt(tokens[1]));
                        break;
                }

                animals.add(animal);

            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }

            input = scanner.nextLine();
        }

        animals.forEach(animal -> System.out.println(animal.toString()));
    }
}
