package vehicleExtension;

public class Bus extends VehicleImpl {
    private static final double AIR_CONDITIONER_EXTRA_CONSUMPTION = 1.4;

    public Bus(double fuelQuantity, double consumption, double tankCapacity) {
        super(fuelQuantity, consumption, tankCapacity);
    }

    @Override
    public String drive(double distance) {
        return "Bus " + super.drive(distance);
    }

    @Override
    public String driveWithPassengers(double distance) {
        this.setConsumption(this.getConsumption() + AIR_CONDITIONER_EXTRA_CONSUMPTION);
        return "Bus " + super.drive(distance);
    }

    @Override
    public void refuel(double liters) {
        super.refuel(liters);
    }

    @Override
    public String toString() {
        return "Bus: " + super.toString();
    }
}
