package birthdayCelebrations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Birthable> birthdays = new ArrayList<>();

        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String[] tokens = input.split("\\s+");

            switch (tokens[0]) {
                case "birthdayCelebrations.foodShortage.Citizen":
                    Citizen citizen = new Citizen(tokens[1],
                            Integer.parseInt(tokens[2]),
                            tokens[3],
                            tokens[4]);
                    birthdays.add(citizen);
                    break;
                case "birthdayCelebrations.Pet":
                    Pet pet = new Pet(tokens[1], tokens[2]);
                    birthdays.add(pet);
                    break;
                case "birthdayCelebrations.Robot":
                    break;
            }

            input = scanner.nextLine();
        }

        String year = scanner.nextLine();

        for (Birthable birthday : birthdays) {
            if (birthday.getBirthDate().endsWith(year)) {
                System.out.println(birthday.getBirthDate());
            }
        }
    }
}
