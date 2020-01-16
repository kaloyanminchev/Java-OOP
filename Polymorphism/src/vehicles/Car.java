package vehicles;

public class Car extends VehicleImpl {
    private static final double AIR_CONDITIONER_EXTRA_CONSUMPTION = 0.9;

    public Car(double fuelQuantity, double consumption) {
        super(fuelQuantity, consumption + AIR_CONDITIONER_EXTRA_CONSUMPTION);
    }

    @Override
    public String drive(double distance) {
        return "Car " + super.drive(distance);
    }

    @Override
    public String toString() {
        return "Car: " + super.toString();
    }
}
