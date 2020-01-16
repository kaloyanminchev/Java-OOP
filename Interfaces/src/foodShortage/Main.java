package foodShortage;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Buyer> buyers = new HashMap<>();

        int numberOfPeople = Integer.parseInt(scanner.nextLine());
        while (numberOfPeople-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");

            Buyer buyer;
            if (tokens.length == 4) {
                buyer = new Citizen(tokens[0],
                        Integer.parseInt(tokens[1]),
                        tokens[2],
                        tokens[3]);
            } else {
                buyer = new Rebel(tokens[0],
                        Integer.parseInt(tokens[1]),
                        tokens[2]);
            }

            buyers.putIfAbsent(tokens[0], buyer);
        }

        String name = scanner.nextLine();
        while (!"End".equals(name)) {
            if (buyers.containsKey(name)) {
                buyers.get(name).buyFood();
            }

            name = scanner.nextLine();
        }

        System.out.println(buyers.values()
                .stream()
                .mapToInt(Buyer::getFood)
                .sum());
    }
}
