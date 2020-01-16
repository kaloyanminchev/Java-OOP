package vehicles;

public class Truck extends VehicleImpl {
    private static final double AIR_CONDITIONER_EXTRA_CONSUMPTION = 1.6;
    private static final double TANK_DECREASE = 0.95;

    public Truck(double fuelQuantity, double consumption) {
        super(fuelQuantity, consumption + AIR_CONDITIONER_EXTRA_CONSUMPTION);
    }

    @Override
    public String drive(double distance) {
        return "Truck " + super.drive(distance);
    }

    @Override
    public void refuel(double liters) {
        super.refuel(liters * TANK_DECREASE);
    }

    @Override
    public String toString() {
        return "Truck: " + super.toString();
    }
}
