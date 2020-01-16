package vehicleExtension;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static final String[] vehicleNames = {"Car", "Truck", "Bus"};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Vehicle> vehicles = new LinkedHashMap<>();
        for (String vehicleName : vehicleNames) {
            vehicles.put(vehicleName, readVehicleInput(scanner.nextLine()));
        }

        int n = Integer.parseInt(scanner.nextLine());
        while (n-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String command = tokens[0];
            String type = tokens[1];
            double value = Double.parseDouble(tokens[2]);

            try {
                if ("Drive".equals(command) && "Bus".equals(type)) {
                    System.out.println(vehicles.get(type).driveWithPassengers(value));
                } else if ("Refuel".equals(command)) {
                    vehicles.get(type).refuel(value);
                } else {
                    System.out.println(vehicles.get(type).drive(value));
                }
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        }

        vehicles.values().forEach(System.out::println);
    }

    private static Vehicle readVehicleInput(String nextLine) {
        String[] tokens = nextLine.split("\\s+");
        double fuel = Double.parseDouble(tokens[1]);
        double liters = Double.parseDouble(tokens[2]);
        double capacity = Double.parseDouble(tokens[3]);

        switch (tokens[0]) {
            case "Car":
                return new Car(fuel, liters, capacity);
            case "Truck":
                return new Truck(fuel, liters, capacity);
            default:
                return new Bus(fuel, liters, capacity);
        }
    }
}
