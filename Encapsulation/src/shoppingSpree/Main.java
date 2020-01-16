package shoppingSpree;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            List<Person> people = Arrays.stream(scanner.nextLine().split(";"))
                    .map(p -> {
                        String[] data = p.split("=");
                        return new Person(data[0], Double.parseDouble(data[1]));
                    })
                    .collect(Collectors.toList());

            List<Product> products = Arrays.stream(scanner.nextLine().split(";"))
                    .map(p -> {
                        String[] data = p.split("=");
                        return new Product(data[0], Double.parseDouble(data[1]));
                    })
                    .collect(Collectors.toList());

            String input = scanner.nextLine();
            while (!"END".equals(input)) {
                String[] data = input.split("\\s+");

                for (Person person : people) {
                    if (person.getName().equals(data[0])) {
                        Product product = null;

                        for (Product p : products) {
                            if (p.getName().equals(data[1])) {
                                product = p;
                            }
                        }

                        if (product != null) {
                            try {
                                person.buyProduct(product);
                                System.out.println(person.getName() + " bought " + product.getName());
                            } catch (IllegalStateException ex) {
                                System.out.println(ex.getMessage());
                            }
                        }
                        break;
                    }
                }

                input = scanner.nextLine();
            }

            for (Person person : people) {
                System.out.println(person.toString());
            }

        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
