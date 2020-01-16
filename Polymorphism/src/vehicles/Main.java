package vehicles;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] carInfo = scanner.nextLine().split("\\s+");
        Car car = new Car(Double.parseDouble(carInfo[1]), Double.parseDouble(carInfo[2]));

        String[] truckInfo = scanner.nextLine().split("\\s+");
        Truck truck = new Truck(Double.parseDouble(truckInfo[1]), Double.parseDouble(truckInfo[2]));

        int n = Integer.parseInt(scanner.nextLine());
        while (n-- > 0) {

            String[] tokens = scanner.nextLine().split("\\s+");
            String command = tokens[0];
            String vehicle = tokens[1];
            double value = Double.parseDouble(tokens[2]);

            switch (command) {
                case "Drive":
                    if (vehicle.equals("Car")) {
                        System.out.println(car.drive(value));
                    } else if (vehicle.equals("Truck")) {
                        System.out.println(truck.drive(value));
                    }
                    break;
                case "Refuel":
                    if (vehicle.equals("Car")) {
                        car.refuel(value);
                    } else if (vehicle.equals("Truck")) {
                        truck.refuel(value);
                    }
                    break;
            }
        }

        System.out.println(car.toString());
        System.out.println(truck.toString());
    }
}
