package vehicleExtension;

public interface Vehicle {
    String drive(double distance);

    String driveWithPassengers(double distance);

    void refuel(double liters);
}
