package vehicleExtension;

import java.text.DecimalFormat;

public abstract class VehicleImpl implements Vehicle {
    private static final DecimalFormat formatter =
            new DecimalFormat("#.##");
    private double fuelQuantity;
    private double consumption;
    private double tankCapacity;

    protected VehicleImpl(double fuelQuantity, double consumption, double tankCapacity) {
        this.setFuelQuantity(fuelQuantity);
        this.setConsumption(consumption);
        this.setTankCapacity(tankCapacity);
    }

    protected double getConsumption() {
        return this.consumption;
    }

    protected void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    protected void setConsumption(double litersPerKilometer) {
        this.consumption = litersPerKilometer;
    }

    protected void setTankCapacity(double tankCapacity) {
        this.tankCapacity = tankCapacity;
    }

    @Override
    public String drive(double distance) {
        if (canDrive(distance)) {
            this.fuelQuantity -= this.consumption * distance;
            return String.format("travelled %s km", formatter.format(distance));
        } else {
            return "needs refueling";
        }
    }

    private boolean canDrive(double distance) {
        return this.fuelQuantity > this.consumption * distance;
    }

    @Override
    public String driveWithPassengers(double distance) {
        return this.drive(distance);
    }

    @Override
    public void refuel(double liters) {
        if (liters <= 0) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
        if (this.fuelQuantity + liters > this.tankCapacity) {
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }
        this.fuelQuantity += liters;
    }

    @Override
    public String toString() {
        return String.format("%.2f", this.fuelQuantity);
    }
}
