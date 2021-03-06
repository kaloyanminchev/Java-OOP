package vehicleExtension;

public class Car extends VehicleImpl {
    private static final double AIR_CONDITIONER_EXTRA_CONSUMPTION = 0.9;

    public Car(double fuelQuantity, double consumption,double tankCapacity) {
        super(fuelQuantity, consumption + AIR_CONDITIONER_EXTRA_CONSUMPTION, tankCapacity);
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
